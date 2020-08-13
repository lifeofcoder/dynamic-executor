package com.lifeofcoder.dynamic.executor;

public class MyClass {
    public String say(String str) {
        return "hello" + str;
    }

    public static void main(String[] args) {
        System.out.println(new MyClass().say("bbbbb"));;
        System.out.println(System.class.getName());
    }
}
