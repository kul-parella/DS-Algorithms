package com.geekForgeeks.Math;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorialNum(4L));
    }

    public static Long factorialNum(Long num) {
        Long result = 1L;
        while(num>0) {
            result = result*num;
            num--;
        }
        return result;
    }
}
