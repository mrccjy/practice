package com.practice.java8;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/11/24 15:29
 */
public class Lamb {
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(1,2,3));
        l.add(Arrays.asList(4,5,6));
        List<List<Integer>> l1 = new ArrayList<>();
        l1.add(Arrays.asList(7,8,9));
        l1.add(Arrays.asList(10,11,12));
        List<List<List<Integer>>> ll = new ArrayList<>();
        ll.add(l);
        ll.add(l1);
        String st = ll.stream().flatMap(t -> t.stream().flatMap(List::stream))
                .map(t -> t.toString()).collect(Collectors.joining(",", "start-", "-end"));
        System.out.println(st);

        Date d = new Date();
        LocalDateTime ldt = d.toInstant().atZone(ZoneId.of(ZoneId.SHORT_IDS.get("JST"))).toLocalDateTime();
        System.out.println("方法一：Date.toInstant().atZone.toLocalDateTime:" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt));
        LocalDateTime ldt2 = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
        System.out.println("方法二：LocalDateTime.ofInstant(Date.toInstant(), ZoneId.systemDefault()):" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt2));
        Date newD = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(newD));
    }
}
