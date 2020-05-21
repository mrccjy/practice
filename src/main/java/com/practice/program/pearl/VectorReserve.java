package com.practice.program.pearl;

public class VectorReserve {
    public static void main(String[] args) {
        AcrobaticsReverse a = new AcrobaticsReverse("abcdefghijklmnopqrst");
        System.out.println(a.reverse(1));
        System.out.println(a.reverse(2));
        System.out.println(a.reverse(3));
        System.out.println(a.reverse(4));
        System.out.println(a.reverse(5));
        System.out.println(a.reverse(6));
        System.out.println(a.reverse(7));
        System.out.println(a.reverse(8));
        System.out.println(a.reverse(9));
        System.out.println(a.reverse(10));
        System.out.println(a.reverse(11));
        System.out.println(a.reverse(12));
        System.out.println(a.reverse(13));
        System.out.println(a.reverse(14));
        System.out.println(a.reverse(15));
        System.out.println(a.reverse(16));
        System.out.println(a.reverse(17));
        System.out.println(a.reverse(18));
        System.out.println(a.reverse(19));
    }
}
class AcrobaticsReverse {
    private String originalStr;
    char[] charStr;
    String reverseStr;

    public AcrobaticsReverse(String charStr) {
        if (charStr == null || charStr.length() == 0) {
            throw new IllegalArgumentException("参数不能为空");
        }
        this.originalStr = charStr;
    }

    /**
     * 从开始下标移动size个字符到末尾
     * 例如：abcdefg    reverse(3)
     * 结果defgabc
     * @param size 个数
     * @return
     */
    public String reverse(int size) {
        if (size < 1 || size > originalStr.length()-1) {
            throw new IllegalArgumentException("参数越界size："+
                    size+","+"array size:"+ charStr.length);
        }
        return reverse0(size);
    }

    private String reverse0(int size) {
        this.charStr = originalStr.toCharArray();
        //计算数组长度length和size的最大公约数，循环移动最大公约数次可完成数组移动
        for (int i = 0; i<gcd(charStr.length, size); i++) {
            char t = charStr[i];
            //待被填充下标
            int j = i;
            //填充源下标
            int k = j+size;
            while (charStr[j] != charStr[k]) {
                charStr[j] = charStr[k];
                //把填充源下标作为下一次的待被填充下标
                j = k;
                //下次填充源下标为这次填充源下标加上位移个数
                k = j + size;
                /*一直加上去会超过数组下标的长度，所以需要进行下标从头循环，循环方法是减去下标值。
                   此处运用到一个检测链表环的概念，理解假设一个链表存在环，那么只要设置快慢指针，每次a1步进1，a2步进2
                   那么存在运行N次后，a1指针与a2指针必定相遇
                 */
                if (k >= charStr.length) {
                    k -= charStr.length;
                }
                if (k == i) {
                    break;
                }

            }
            charStr[j] = t;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< charStr.length; i++) {
            sb.append(charStr[i]);
        }
        this.reverseStr = sb.toString();
        return reverseStr;
    }

    private int gcd(int length, int size) {
        if (length%size == 0) {
            return size;
        }
        for (int i=size-1; i>0; i--) {
            if (length%i == 0 && size%i == 0) {
                return i;
            }
        }
        return 1;
    }
}
