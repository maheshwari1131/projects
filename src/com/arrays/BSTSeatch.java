package com.arrays;
import java.lang.Math;
import java.util.*;

public class BSTSeatch {

    public static void main(String args[]){
        int m[][]={{1,2,3},{4,5,6},{7,8,9}};
        int target=8;
       System.out.println(search(m,target));
    }
    public static boolean search(int m[][], int t){
        // given array is null or empty
        if(m==null || m.length==0){
            return false;
        }
        int s=Math.min(m.length,m[0].length);

        for(int i=0;i<s;i++){
            boolean foundV=binarySearch(m,t,i,true);
            boolean foundH=binarySearch(m,t,i,false);
            if(foundH||foundV){
                return true;
            }
        }

        return false;
    }
    public static boolean binarySearch(int [][] m, int t, int start, boolean v){
        int lo=start;
        int hi=v?m[0].length-1:m.length-1;
        while(hi>=lo){
            int mid=(lo+hi)/2;
            if(v){
                // search in column
                if(m[start][mid]<t){
                    lo=mid+1;
                }else if(m[start][mid]>t){
                    hi=mid-1;
                }else{
                    return true;
                }
            }else{
                // search in row

                if(m[mid][start]<t){
                    lo=mid+1;
                }else if(m[mid][start]>t){
                    hi=mid-1;
                }else{
                    return true;
                }

            }

        }

        return false;
    }
}
