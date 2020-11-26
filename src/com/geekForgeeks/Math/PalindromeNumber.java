package com.geekForgeeks.Math;

import java.awt.*;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(palindrome(new Long(8778)));
    }



    public static boolean palindrome(Long num) {
        Long rev = reverseNum(num);
        return rev.equals(num);
    }

    public static Long reverseNum(Long num) {

        Long rev= 0L;

        while(num>0) {
              rev = (rev* 10) + num%10;
              num = num/10;
        }

        return rev;
    }


}