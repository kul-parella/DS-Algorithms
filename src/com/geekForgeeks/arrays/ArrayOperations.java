package com.geekForgeeks.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayOperations {

    public static void main(String[] args) {

        int[] arr = new int[8];
        arr[0]=4;
        arr[1]=0;
        arr[2]=9;
        arr[3]=6;
        arr[4]=0;
        arr[5]=7;
        arr[6]=0;
        arr[7]=8;
        //System.out.println("length :: "+arr.length);

        //Arrays.stream(insert(arr, 2, 3)).forEach(x ->System.out.println(x));
        //Arrays.stream(delete(arr, 34)).forEach(x->System.out.println(x));
        //System.out.println("First Largest"+largestElementInArr(arr));
        //System.out.println("Second Largest"+secondLargestElementInArr(arr));
        //System.out.println("Array sorted::"+arraySorted(arr));
       // Arrays.stream(reverseArray(arr)).forEach(x-> System.out.println(x));
        //System.out.println("new Size::"+removeDuplicatesFromSortedArr(arr, 8));
        //Arrays.stream(moveZerosToEndWithoutOrderChange(arr)).forEach(x-> System.out.println(x));
        //Arrays.stream(leftRotateArray_D_Positions(arr, 2)).forEach(x->System.out.println(x));
        //Arrays.stream(leftRotateArray_D_Positions_better(arr, 2)).forEach(x->System.out.println(x));
        printLeadersOfArray(arr);
    }

    public static int[] insert(int[] arr, int offsetToInsert, int elementToInsert) {

        if(offsetToInsert >= arr.length-1) {
            return arr;
        } else {
            for(int i=arr.length-1; i<offsetToInsert; i--) {
                arr[i+1]=arr[i];
            }
            arr[offsetToInsert]=elementToInsert;
            return arr;
        }

    }

    public static int[] delete(int[] arr, int elementToDelete) {

        for(int i=0; i<=arr.length-1; i++) {
            if(elementToDelete == arr[i]){
                for(int j = i+1; j<=arr.length-1; j++) {
                    arr[j-1] =arr[j];
                }
                break;
            }
        }
        arr[arr.length-1]=0;

        return arr;
    }

    public static int largestElementInArr(int[] arr) {
        int largest=0;
        for(int i=0; i<arr.length-1; i++) {
            largest=arr[i];
            if(arr[i+1]>arr[i]){
                largest=arr[i+1];
            }
        }
        return largest;
    }

    public static int secondLargestElementInArr(int[] arr) {
        int largest=0;
        int secondLargest =0;
        for(int i=0; i<=arr.length-1; i++) {
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
            if( arr[i]<largest && arr[i]>secondLargest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }

    public static boolean arraySorted(int[] arr) {
        boolean sorted = true;
        for(int i=0; i<arr.length-1;i++) {
            if(arr[i]>arr[i+1]){
                sorted=false;
            }
        }

        return sorted;
    }

    public static int[] reverseArray(int[] arr) {

        int[] newArr = new int[arr.length];

        for(int i=arr.length-1, j=0; i>=0; i--, j++) {
            newArr[j]=arr[i];
        }

        return newArr;
    }

    public static int removeDuplicatesFromSortedArr(int[] arr, int size){

        int newSize =1;
        for(int i=0; i<arr.length-1;){

            /*
            int counter=0;
            boolean breakFalg = false;
            for(int z=i;z<arr.length;z++) {
                if(arr[z]==0){
                    counter++;
                }
                if(counter== arr.length-i){
                    breakFalg=true;
                    break;
                }
            }

            if(breakFalg==true) break;
            */

            if(arr[i+1]<arr[i]) break;

            if(arr[i]==arr[i+1]){
              for(int j=i+1; j<arr.length-1;j++) {
                  arr[j]=arr[j+1];
                  if(j+1==arr.length-1) {
                      arr[j+1]=0;
                  }
              }
            }else {
                i++;
                newSize++;
            }



        }
        Arrays.stream(arr).forEach(x-> System.out.println(x));
        return newSize;
    }

    public static int[] moveZerosToEndWithoutOrderChange(int[] arr) {

        int[] newArr = new int[arr.length];
        int j=0;
        for(int i=0; i<arr.length;i++) {
            if(arr[i]!=0) {
              newArr[j]=arr[i];
              j++;
            }
        }

        return newArr;
    }

    public static int[] leftRotateArray_D_Positions(int[] arr, int position) {

        int[] newArr = new int[position];

        //copying the d positions into temp array
        for(int i=0; i<position-1; i++) {
            newArr[i] = arr[i];
        }

        for(int i=position, j=0; i<arr.length;i++, j++) {
            arr[j] = arr[i];
        }

        for(int i = arr.length-1, j=newArr.length-1; j>=0 ; j--, i--) {
            arr[i] = newArr[j];
        }

    return arr;

    }

    public static int[] leftRotateArray_D_Positions_better(int[] arr, int position) {

        //creating new array with same length as original array
        int[] positionReverseArr = new int[arr.length];

        //  reverse original array elements still position and save it to new array
        // original array [4 0 5 6 0 7 0 8], say position is 2
        // new array will be [0 4 0 0 0 0 0 0]
        for (int i = position - 1, j = 0; i >= 0; i--, j++) {
            positionReverseArr[j] = arr[i];
        }

        //reverse the elements in the second half, position to end of the array and save it to the end of the new array
        // new array will be [0 4 8 0 7 0 6 5]
        for (int i = arr.length - 1, j = position; i >= position; i--, j++) {
            positionReverseArr[j] = arr[i];
        }

        //reverse the new array and save it to original array and return
        //[5 6 0 7 0 8 4 0]
        for (int i = positionReverseArr.length - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = positionReverseArr[i];
        }

        return arr;
    }


    // leaders in array is something, number which doesn't have greater values in the right side of it.
    public static void printLeadersOfArray(int[] arr) {

      int presentLeader = arr[arr.length-1];

      System.out.print(presentLeader);

      for(int i=arr.length-2; i>=0; i--) {
          if(arr[i]>presentLeader) {
              System.out.print(" "+arr[i]);
          }
      }

    }

//    public static void maxDifference(int[] arr) {
//
//
//        for()
//
//    }

}
