package com.test;

public class Test {
    public static void main(String[] args) {
        String str = "1111asss";
        boolean isNum = str.matches("[0-9]+");
        System.out.println(isNum);
    }
}
