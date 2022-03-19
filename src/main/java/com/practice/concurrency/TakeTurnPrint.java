package com.practice.concurrency;
/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/10/28 17:53
 */
public class TakeTurnPrint {
    //个位1表示字母打印完成，十位1表示数字打印完成
    static volatile int flag = 0;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread num = new Thread(new NumPrinterThread(lock));
        Thread lett = new Thread(new lettPrinterThread(lock));
        num.start();
        lett.start();
//        byte i= 3;
//        System.out.println("i="+i+", i&2="+(i&2));
//        System.out.println("i="+i+", i&1="+(i&1));
//        i = 2;
//        System.out.println("i="+i+", i&2="+(i&2));
//        System.out.println("i="+i+", i&1="+(i&1));
//        i = 1;
//        System.out.println("i="+i+", i&2="+(i&2));
//        System.out.println("i="+i+", i&1="+(i&1));
//        i = 0;
//        System.out.println("i="+i+", i&2="+(i&2));
//        System.out.println("i="+i+", i&1="+(i&1));
    }
}

class NumPrinterThread implements Runnable {

    private char[] num = "0123456789".toCharArray();

    private Object lock;

    public NumPrinterThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                int i = 0;
                while (!Thread.currentThread().isInterrupted() && i<num.length) {
                    System.out.println(num[i++]);
                    //判断字母是否打印完成，打印完成不唤醒休眠，直接打印完成自己的数字
                    if ((TakeTurnPrint.flag & 1) != 1) {
                        lock.notifyAll();
                        lock.wait();
                    }
                }
                //设置十位标识为完成
                TakeTurnPrint.flag |= 2;
            } catch (InterruptedException ex) {

            } finally {
                lock.notifyAll();
            }
        }
    }
}

class lettPrinterThread implements Runnable {

    private char[] lett = "abcdefghijklmn".toCharArray();

    private Object lock;

    public lettPrinterThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                int i = 0;
                while (!Thread.currentThread().isInterrupted() && i<lett.length) {
                    System.out.println(lett[i++]);
                    //判断数字是否打印完成，打印完成不唤醒休眠，直接打印完成自己的字母
                    if ((TakeTurnPrint.flag & 2) != 2) {
                        lock.notifyAll();
                        lock.wait();
                    }
                }
                //设置个位标识为完成
                TakeTurnPrint.flag |= 1;
            } catch (InterruptedException ex) {

            } finally {
                lock.notifyAll();
            }
        }
    }
}
