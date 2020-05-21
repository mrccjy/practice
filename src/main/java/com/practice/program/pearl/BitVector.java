package com.practice.program.pearl;
/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2020/5/19 14:44
 */
public class BitVector {
    private static final int SEPARATORWORD = 32;
    private static final int MASK = 31;
    private static final byte SHIFT = 5;
    private final int n;
    private final int[] arr;

    public BitVector(int n) {
        this.n = n;
        this.arr = new int[1+ (n>>SHIFT)];
        for (int i=0; i<n; i++) {
            clear(i);
        }
    }

    public void clear(int i) {
        if (i < 0 || (i>>SHIFT) > arr.length -1) {
            return;
        }
        arr[i >> SHIFT] &= ~(1 << (i & MASK));
    }

    public void set(int i) {
        if (i < 0 || (i>>SHIFT) > arr.length -1) {
            return;
        }
        arr[i >> SHIFT] |= 1 << (i & MASK);
    }

    public int test(int i) {
        if (i < 0 || (i>>SHIFT) > arr.length -1) {
            return 0;
        }
        return (arr[i >> SHIFT] >> (i & MASK)) & 1;
    }

    public static void main(String[] args) {
        BitVector b = new BitVector(10000);
        for (int i=100; i<105; i++) {
            b.set(i);
        }
        for (int i=0; i<10000; i++) {
            if (b.test(i)>0) {
                System.out.println(i+":"+b.test(i));
            }
        }
        System.out.println("===============================================");
        for (int i=100; i<104; i++) {
            b.clear(i);
        }
        for (int i=0; i<10000; i++) {
            if (b.test(i)>0) {
                System.out.println(i+":"+b.test(i));
            }
        }
        System.out.println(b.test(11000));
    }
}
