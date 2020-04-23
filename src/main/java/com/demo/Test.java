package com.demo;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> res;

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> res = new Stack<Integer>();

        for (String i :
                tokens) {
            if (i == "+" || i == "-" || i == "*" || i == "/") {
                if (res.size() < 2) {
                    return 0;
                }
                int a = res.pop();
            }

        }


        return 0;

    }
}
