package com.prac;

public class SubString {

    public static void main(String args[]){

        String s="abcabcbb";

        int length =findSubLength(s);
        System.out.println(length);

        int expected=0;
        assert length==expected?false:true;

    }


    public static int findSubLength(String s){
        int l=0;
        int r=0;
        int []chars=new int[128];
        int res=0;
        while(r<s.length()){

            char rc=s.charAt(r);
            chars[rc]++;

// if duplicate found
            while(chars[rc]>1){
                char lc=s.charAt(l);
                chars[lc]--;
                l++;
            }

            res=Math.max(res,r-l+1);

            r++;
        }

        return res;


    }

}
