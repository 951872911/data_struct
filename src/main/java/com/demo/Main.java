package com.demo;

public class Main {

    public static int split(int number) {
        if (number > 1) {
            if (number % 2 != 0) System.out.print(split((number + 1) / 2));
            System.out.print(split(number / 2));
        }
        return number;
    }

    public static void main (String[] args) {
        split(12);
    }
}
