package com.geekForgeeks.Math;

public class NumOfDigitsOfNum {

    public static void main(String[] args) {
        System.out.println("Num of Digits of the number: "+numOfDigits(new Long(678910)));
        System.out.println("Num of Digits of the number using Log function: "+logarithmic(new Long(678910)));
        System.out.println("Num of Digits of the number using Recursive: "+recursive1(new Long(974720)));
    }


    public static int numOfDigits(Long number){

        int count =0;
        while(number>0) {
            number =number/10;
            ++count;
        }
        return count;
    }

    public static int logarithmic(Long number) {
        return(int) Math.floor(Math.log10(number)+1);
    }

    public static int recursive1(Long number) {
        if(number==0)
            return 0;
        return 1+ recursive1(number/10);

    }


}
