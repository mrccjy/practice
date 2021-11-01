package com.practice.sort;
/**
 *  @description: TODO
 *  @author chen.junyong
 *  @date 2021/6/4 9:00
 */
public class Parent {
    int i = 1;
    {
        System.out.println("firt parent");
    }

    public Parent() {
        System.out.println("parent init:i="+ i);
    }
    {
        System.out.println("i="+ i);
    }

    public static void main(String[] args) {
        new Child();
    }
}

class Child extends Parent {
    int j = 2;

    {
        System.out.println("firt child");
    }
    public Child() {
        System.out.println("child init:j="+ j);
    }
    {
        System.out.println("j="+ j);
    }
}