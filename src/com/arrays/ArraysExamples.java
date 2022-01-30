package com.arrays;
import java.lang.*;
import java.io.*;
import java.util.*;


public class ArraysExamples
{
    public static void main(String args[]){
        int[] arr = {1,0,2,3,0,4,5,0};
        //duplicateZeros(arr);

        int a[][]={{1,2,3},{4,0,7}};
        System.out.println(a.length);
        System.out.println(a[0].length);

        System.out.println(a[0][1]);

        System.out.println(a[1][2]);

    }

    private static int evenDigits(int val[]){
        int l=0;
        //Input: nums = [12,345,2,6,7896]
        //Output: 2
        System.out.println("");




        return l;
    }

    private static int getDigits(int n){
        int d=0;
        while(n>0){
            n=n/10;
            d++;
        }
        return d;
    }

    private static void duplicateZeros(int[] arr) {
        //  Input: arr = [1,0,2,3,0,4,5,0]
//Output: [1,0,0,2,3,0,0,4]

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                for(int j=arr.length-1;j>i;j--){
                    System.out.println("j="+j);
                    arr[j]=arr[j-1];
                }
                i++;
            }
        }


    }

    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }

    private void helper(int start, int end, char [] s) {
        if (start >= end) {
            return;
        }
        // swap between the first and the last elements.
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        helper(start + 1, end - 1, s);
    }
}
