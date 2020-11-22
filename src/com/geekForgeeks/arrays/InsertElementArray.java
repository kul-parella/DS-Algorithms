package com.geekForgeeks.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InsertElementArray {

    public static void main(String[] args) {

        int[] arr = new int[8];
        arr[0]=22;
        arr[1]=34;
        arr[2]=56;
        arr[3]=65;
        arr[4]=44;
        System.out.println("length :: "+arr.length);
        Arrays.stream(insert(arr, 3, 3)).forEach(x ->System.out.println(x));

    }

    public static int[] insert(int[] arr, int offsetToInsert, int elementToInsert) {

        for(int i=arr.length-1; i<offsetToInsert; i--) {
            arr[i+1]=arr[i];
        }
        arr[offsetToInsert]=elementToInsert;
        return arr;
    }

}
