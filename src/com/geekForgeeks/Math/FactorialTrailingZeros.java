package com.geekForgeeks.Math;

public class FactorialTrailingZeros {

    public static void main(String[] args) {
        System.out.println(trailingZerosOfFactorial(100L));
    }

    public static int trailingZerosOfFactorial(Long num) {
        Long factorial = factorialOfNum(num);
        return trailingZeros(factorial);
    }

    public static Long factorialOfNum(Long num){
        Long fact = 1L;
        while(num>0){
            fact = fact * num;
            num--;
        }
        return fact;
    }

    public static int trailingZeros(Long num) {

        int result=0;

        while(num>0) {
            if(num%10 != 0){
                break;
            }else {
                result++;
            }
            num = num/10;
        }

        return result;
    }
}
