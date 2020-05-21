package com.practice.program.pearl;

public class VectorReserve {
    public static void main(String[] args) {

    }
}
class AcrobaticsReverse {
    final char[] orignalStr;
    String reverseStr;

    public AcrobaticsReverse(String orignalStr) {
        if (orignalStr == null || orignalStr.length() == 0) {
            throw new IllegalArgumentException("参数不能为空");
        }
        this.orignalStr = orignalStr.toCharArray();
    }

    /**
     * 从开始下标移动size个字符到末尾
     * 例如：abcdefg    reverse(3,2)
     * 结果abcfgde
     * @param startIndex 开始下标
     * @param size 个数
     * @return
     */
    public String reverse(int startIndex, int size) {
        if (startIndex < 0 || startIndex > orignalStr.length-1 || size < 1 || size > orignalStr.length-startIndex-1) {
            throw new IllegalArgumentException("参数非法或越界startIndex："+
                    startIndex + ",size: "+size+","+"array size:"+ orignalStr.length);
        }
        return reverse0(startIndex, size);
    }

    private String reverse0(int startIndex, int size) {
        int start = startIndex;
        int end = start + size;
        int waitMoveIndex = end;
        while (start<end && orignalStr[waitMoveIndex%orignalStr.length] != orignalStr[start]) {

         }
        return null;
    }
}
