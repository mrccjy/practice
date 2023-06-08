package com.practice.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/10/28 17:53
 */
public class TakeTurnPrintCondition {
    //1为数字可执行，2为字符可执行
    static int NUMTURN = 1, LETTTURN = 2;
    static volatile int flag = 1;
    static volatile int finishFlag = 0;
    static volatile int numI = 0;
    static volatile int lettI = 0;
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition lett = lock.newCondition();
        Condition num = lock.newCondition();
        Thread numT = new Thread(new NumPrinterThreadCondtion(lock,lett,num));
        Thread lettT = new Thread(new lettPrinterThreadCondtion(lock,lett,num));
        Thread numT2 = new Thread(new NumPrinterThreadCondtion(lock,lett,num));
        Thread lettT2 = new Thread(new lettPrinterThreadCondtion(lock,lett,num));
        Thread numT3 = new Thread(new NumPrinterThreadCondtion(lock,lett,num));
        Thread lettT3 = new Thread(new lettPrinterThreadCondtion(lock,lett,num));
        Thread numT4 = new Thread(new NumPrinterThreadCondtion(lock,lett,num));
        Thread lettT4 = new Thread(new lettPrinterThreadCondtion(lock,lett,num));
        lettT.start();
        numT.start();
        lettT2.start();
        numT2.start();
        lettT3.start();
        numT3.start();
        lettT4.start();
        numT4.start();
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

class NumPrinterThreadCondtion implements Runnable {

    private char[] num = "012345678912345679019876543".toCharArray();

    private Lock lock;
    private Condition lettC;
    private Condition numC;

    public NumPrinterThreadCondtion(Lock lock, Condition lett, Condition num) {
        this.lock = lock;
        this.lettC = lett;
        this.numC = num;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (!Thread.currentThread().isInterrupted() && TakeTurnPrintCondition.numI<num.length) {
                //判断是否过了数字打印轮次，并且字符打印还没完成，唤醒字符打印，睡眠数字打印,
                // 此处用if会有并发风险。多cpu架构机器上即便使用notify也会唤醒多个等待的线程造成并发风险
                while (TakeTurnPrintCondition.flag != TakeTurnPrintCondition.NUMTURN
                        && (TakeTurnPrintCondition.finishFlag & 1) != 1) {
                    lettC.signalAll();
                    numC.await();
                }
                if (TakeTurnPrintCondition.numI<num.length) {
                    //如果字符打印还没完成，设置表示为字符打印轮次
                    if ((TakeTurnPrintCondition.finishFlag & 1) != 1) {
                        TakeTurnPrintCondition.flag = TakeTurnPrintCondition.LETTTURN;
                    }
                    System.out.println(num[TakeTurnPrintCondition.numI++]);
                }
            }

            //设置十位标识为完成，设置数字打印完成状态
            TakeTurnPrintCondition.finishFlag |= 2;

        } catch (InterruptedException ex) {

        } finally {
            //最后唤醒字符打印，防止字符打印还没打印完
            lettC.signalAll();
            lock.unlock();
        }
    }
}

class lettPrinterThreadCondtion implements Runnable {

    private char[] lett = "abcdefghijklmn".toCharArray();

    private Lock lock;
    private Condition lettC;
    private Condition numC;

    public lettPrinterThreadCondtion(Lock lock, Condition lettC, Condition num) {
        this.lock = lock;
        this.lettC = lettC;
        this.numC = num;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (!Thread.currentThread().isInterrupted() && TakeTurnPrintCondition.lettI<lett.length) {
                //判断是否还没轮到字符打印，并且数字打印还没完成，唤醒数字打印，字符打印休眠
                // 此处用if会有并发风险。多cpu架构机器上即便使用notify也会唤醒多个等待的线程造成并发风险
                while (TakeTurnPrintCondition.flag != TakeTurnPrintCondition.LETTTURN
                        && (TakeTurnPrintCondition.finishFlag & 2) != 2) {
                    numC.signalAll();
                    lettC.await();
                }
                if (TakeTurnPrintCondition.lettI<lett.length) {
                    //如果数字打印还没完成，设置轮次为数字打印轮次
                    if ((TakeTurnPrintCondition.finishFlag & 2) != 2) {
                        TakeTurnPrintCondition.flag = TakeTurnPrintCondition.NUMTURN;
                    }
                    System.out.println(lett[TakeTurnPrintCondition.lettI++]);
                }
            }

            //设置个位标识为完成，设置字符打印完成
            TakeTurnPrintCondition.finishFlag |= 1;

        } catch (InterruptedException ex) {

        } finally {
            //最后唤醒数字打印，防止数字打印还没打印完
            numC.signalAll();
            lock.unlock();
        }
    }
}
