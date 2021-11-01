package com.practice.concurrency;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/11/1 15:01
 */
public class ProducerConsumerCondition {
    private LinkedList<String> list = new LinkedList<>();
    private static final int MAX = 10;
    private int count;

    ReentrantLock lock = new ReentrantLock();
    Condition consumer = lock.newCondition();
    Condition producer = lock.newCondition();

    public void put(String s) {
        try {
            lock.lock();
            while (list.size() == MAX) {
                producer.await();
            }
            list.add(s);
            Thread.sleep(200);
            count++;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        String s = null;
        try {
            lock.lock();
            while (list.isEmpty()) {
                consumer.await();
            }
            s = list.removeFirst();
            Thread.sleep(200);
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return s;
    }

    public static void main(String[] args) {
        ProducerConsumerCondition p = new ProducerConsumerCondition();
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
