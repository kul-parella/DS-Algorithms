package com.geekForgeeks.StringOps;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class StringOps {

    /*
    String class in java is immutable and by default thread safe as they immutable
    StringBuffer is thread safe can be shared across multiple threads
    StringBuilder is not thread safe and limited to only one thread
    Above classes provide multiple methods to perform operations on string
    */

    static String str = "geek for geeks";

    public static void main(String[] args) {

        //stringOpsInStringClass(str);
        //charsAndFrequencyPrintedInAscendingOrderOfCharsUsingArray(str);
        //charsAndFrequencyPrintedInAscendingOrderOfCharsUsingTreeMap(str);
        //System.out.println(anagramNaive("aaceb","aecba"));
        //System.out.println(anagram_efficient("silent","listen"));
        //System.out.println(firstMostRepeatingChar(str));
        //System.out.println(reverseString(str));
        System.out.println(reverseWordsInString(str));

    }

    public static void stringOpsInStringClass(String str) {
        System.out.println(str.length());

        System.out.println(str.charAt(3));

        System.out.println(" .substring(2) provides you the substring from index provided :" + str.substring(2));

        System.out.println(" .substring(2,5) provides substring from and to index" +
                "(start index is included and end index is excluded)) :" + str.substring(2, 5));

        System.out.println(str.contains("geeks"));

        System.out.println("g comes before h, so lexicographically g is smaller, so returns -1 : " + str.compareTo("half"));

        System.out.println("f comes before e, so lexicographically e is smaller, so returns +2 : " + str.compareTo("easy"));

        System.out.println("lexicographically equal : " + str.compareTo("geekforgeeks"));

        System.out.println(" .indexOf returns -ve value if string doesn't present  : " + str.indexOf("not_found"));

        System.out.println(" .indexOf returns first occurrence index  : " + str.indexOf("geeks"));


    }

    public static void charsAndFrequencyPrintedInAscendingOrderOfCharsUsingArray(String str) {

        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println((char) (i + 'a') + ":" + count[i]);
            }
        }
    }

    public static void charsAndFrequencyPrintedInAscendingOrderOfCharsUsingTreeMap(String str) {

        Map map = new TreeMap<String, Integer>();

        for (int i = 0; i < str.length(); i++) {
            if (map.keySet().contains(str.charAt(i))) {
                map.put(str.charAt(i), (int) map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }


    public static boolean anagramNaive(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();

        Arrays.sort(str1Char);
        Arrays.sort(str2Char);

        String s1 = new String(str1Char);
        String s2 = new String(str2Char);

        return s1.equals(s2);


    }

    public static boolean anagram_efficient(String str1, String str2) {

        //if we are dealing with only lower case characters of english we can we 26 as capacity
        // C uses ASCII characters 256, where as Java used UTP16 which can handle other languages
        // first 128 characters of UTP16 is same as ASCII
        int[] count = new int[256];

        boolean flag = true;

        if (str1.length() != str2.length()) {
            flag = false;
        }

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (count[i] != 0) {
                flag = false;
            }
        }

        return flag;
    }

    public static char firstMostRepeatingChar(String str) {

        int[] count = new int[256];

        int index = -1;

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
            if (count[str.charAt(i)] > 1) {
                index = i;
                break;
            }
        }

        return str.charAt(index);
    }


    public static String reverseString(String str) {

        //StringBuffer provides reverse method
        //return new StringBuilder(str).reverse().toString();

        char[] reverse = new char[str.length()];

        for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            reverse[j] = str.charAt(i);
        }

        return new String(reverse);
    }


    public static String reverseWordsInString(String str) {

    /*
        //with this approach last char is missing
        int temp = 0;

        String reverseStr = new String();

        for (int i = 0; i < str.length(); i++) {

            if (' ' == str.charAt(i) || i==str.length()-1 ) {

                reverseStr = reverseStr + str.substring(temp, i)+ " ";
                temp = i + 1;
            }
       }

        if (temp == 0) {
            reverseStr = str;
        }

        return reverseStr;

    }

    */

     /*   Pattern pattern = Pattern.compile("\\s");

        String[] arr = pattern.split(str);

      */

        String[] arr =  str.split(" ");

        String reverse = new String();

        for (int i = arr.length - 1; i >= 0; i--) {
            reverse = reverse +" "+ arr[i];
        }
        return reverse;
    }
}

