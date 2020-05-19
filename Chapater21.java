package com.practice;

import java.util.*;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2020/5/19 11:43
 */
public class Chapater21 {
    public static void main(String[] args) {
        Identification i = new Identification("stoop", "poots", "ptsoo", "haash", "aahhs", "aacccbbzzzzee", "eezzzzcccbbaa");
        System.out.println(i.unmodifiableMap);
    }
}
class Identification{
    private static final String STR = "abcdefghijklmnopqrstuvwxyz";
    String[] words;
    final Map<String, List<String>> idenfyMap = new HashMap<String, List<String>>();
    final Map<String, List<String>> unmodifiableMap;

    public Identification(String ... words) {
        this.words = words;
        for (String s : words) {
            char[] lowerCase = s.toLowerCase().toCharArray();
            char[] sortedChar = sort(lowerCase);
            String shrinkChar = shrink(sortedChar);
            List<String> l = idenfyMap.get(shrinkChar);
            if (l == null) {
                l = new ArrayList<String>();
                idenfyMap.put(shrinkChar, l);
            }
            l.add(s);

        }
        this.unmodifiableMap = Collections.unmodifiableMap(idenfyMap);
    }

    private String shrink(char[] sortedChar) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < sortedChar.length) {
            int tmpNum = 1;
            char tmpC = sortedChar[i];
            sb.append(tmpC);
            i++;
            while (i < sortedChar.length && tmpC == sortedChar[i]) {
                tmpNum++;
                i++;
            }
            if (tmpNum != 1) {
                sb.append(tmpNum);
            }
        }
        return sb.toString();
    }

    private char[] sort(char[] lowerCase) {
        char[] sorted = new char[lowerCase.length];
        for (int i=0; i<sorted.length; i++) {
            sorted[i] = lowerCase[i];
        }
        for (int i=0; i<sorted.length; i++) {
            char tmp = 0;
            for (int j=sorted.length-1; j>i; j--) {
                if (STR.indexOf(sorted[i]) > STR.indexOf(sorted[j])) {
                    tmp = sorted[j];
                    sorted[j] = sorted[i];
                    sorted[i] = tmp;
                }
            }
        }
        return sorted;
    }
}