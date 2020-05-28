package com.practice.program.pearl;

public class BlockSwitch {
    static  String originalStr;
    static char[] charStr;

    public static void main(String[] args) {
        charStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        System.out.println(swap(0, 12, 10));
    }

    public static String blockSwitch(int rotdist) {

        return null;
    }

    /**
     *  从开始下标和结束下标处开始，交换size个元素
     * @param start 开始下标
     * @param end   结束下标
     * @param size  移动个数
     * @return
     */
    public static String swap(int start, int end, int size) {
        for (int t=0, i=start, j=end; i<j && t<size; t++, i++, j++) {
            char tmp = charStr[i];
            charStr[i] = charStr[j];
            charStr[j] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charStr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
