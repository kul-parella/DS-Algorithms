package com.geekForgeeks.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ElementPresentOrNot {

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 56, 98, 3, 45, 98};
       // System.out.println(presentOrNot(arr, 56));
        System.out.println(presentReturnIndex(arr, 56));
    }

    public static boolean presentOrNot(int[] arr, int element ) {
        return Arrays.stream(arr).anyMatch( x -> x==element);
    }

    public static int presentReturnIndex(int[] arr, int element) {

        return IntStream.range(0, arr.length)
                .filter(i -> element == arr[i])
                .findFirst()
                .orElse(-1);	// return -1 if target is not found
    }

}
