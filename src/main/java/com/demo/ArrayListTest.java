package com.demo;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList list = new ArrayList(10);
        list.add(null);
//        list.ensureCapacity(20);
//        list.set(5, 1);
        System.out.println(list.size());
    }
}
