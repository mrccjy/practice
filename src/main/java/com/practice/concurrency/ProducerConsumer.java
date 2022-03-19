package com.practice.concurrency;

import java.util.LinkedList;
import java.util.Random;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/11/1 14:32
 */
public class ProducerConsumer {
    private LinkedList<String> list = new LinkedList<>();
    private static final int MAX = 10;
    private int count;

    public synchronized void put(String s) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(s);
        count++;
        this.notifyAll();
    }

    public synchronized String get() {
        while (list.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = list.removeFirst();
        count--;
        this.notifyAll();
        return s;
    }

    public static void main(String[] args) {
        ProducerConsumer p = new ProducerConsumer();
        final Random r = new Random(55);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {while(true) p.put(String.valueOf(r.nextInt(10)));}, "producer"+i).start();
        }
        for (int i = 0; i < 2; i++) {
            final String si = String.valueOf(i);
            new Thread(() -> {while(true) System.out.println("Thread("+ Thread.currentThread().getName()+")consumer value:" + p.get());}, "consumer"+i).start();
        }
    }
}
