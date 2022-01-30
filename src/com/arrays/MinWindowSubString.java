package com.arrays;

import java.util.HashMap;
import java.util.Map;

/*

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

        The testcases will be generated such that the answer is unique.*/
public class MinWindowSubString {



    public String minWindow(String s, String t) {

        // keep t in map , with count of characters

        //create another map with substring map

        // intialize 2 pointers start and end of the window

        // iterate String S until reach end

        // each char put in map, if contains tstring and incmrent

        // check the matches the total count of characters

        // if matches move start pointer to right side until window is not desirable.

        //then repeat move end pointer



        if(s.length()==0 || t.length()==0){
            return "";
        }

        // keep all t s in map


        // overall unique characters in the T


        Map<Character,Integer> tmap=new HashMap<Character,Integer>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }

        //unique keys size

        int requiredCount=tmap.size();
        int l=0;
        int r=0;
        Map<Character,Integer> windowCo=new HashMap<Character,Integer>();
        int [] ans={-1,0,0};

        int n=s.length();
        int formed=0;

        // s = "ADOBECODEBANC", t = "ABC"

        while(r<n){
            char c=s.charAt(r);
            int count=windowCo.getOrDefault(c,0);
            windowCo.put(c,count+1);

            //if frequestcy of current charecter is equals to disired count increment formed

            if(tmap.containsKey(c)&&windowCo.get(c).intValue()==tmap.get(c).intValue()){
                formed++;
            }

            //try and contract the window till the point where it cesease to be desired.

            while(l<=r && formed==requiredCount){

                 c=s.charAt(l);
                 //save the smallest window untill

                if(ans[0]==-1 || r-l+1<ans[0]){
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                //the character at the position ponited by left no longer in window, as left

                windowCo.put(c,windowCo.get(c)-1);

                if(tmap.containsKey(c)&&windowCo.get(c).intValue()<tmap.get(c).intValue()){
                    formed--;
                }
                
                l++;

            }



            r++;

        }

        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);

    }
}
