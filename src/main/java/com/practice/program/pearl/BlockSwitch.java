package com.practice.program.pearl;

/**
 * 块交换算法
 */
public class BlockSwitch {
    static  String originalStr;
    static char[] charStr;

    public static void main(String[] args) {
        originalStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        blockSwitch(2);
    }

    public static String blockSwitch(int rotdist) {
        charStr = originalStr.toCharArray();
        int n = charStr.length;
        int i = rotdist,
            p = rotdist,
            j = n - p;
        while (i != j) {
            if (i > j) {
                swap(p - i, p, j);
                i -= j;
            } else {
                swap(p - i, p + j - i, i);
                j -= i;
            }
            print();
        }
        swap(p - i, p, i);

        return print();
    }

    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (char c : charStr) {
            sb.append(c);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     *  从开始下标和结束下标处开始，交换size个元素
     * @param start 开始下标
     * @param end   结束下标
     * @param size  移动个数
     * @return
     */
    public static void swap(int start, int end, int size) {
        for (int t=0, i=start, j=end; i<j && t<size; t++, i++, j++) {
            char tmp = charStr[i];
            charStr[i] = charStr[j];
            charStr[j] = tmp;
        }

        return;
    }
}
