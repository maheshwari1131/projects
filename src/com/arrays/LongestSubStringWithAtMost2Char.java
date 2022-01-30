package com.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtMost2Char {

    /*
    Given a string s, return the length of the longest substring that contains at most two distinct characters.



Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.



     */

    public int lengthOfLongestSubstringTwoDistinct1(String s) {

        //take 2 pointers
        //right pointer move and store values in list
        //check it has 2 disctict chars already

        return 0;

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n=s.length();
        if(n<3){
            return n;
        }

        int l=0;
        int r=0;
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        int max=0;


        while(r<n){
            char c=s.charAt(r);
            map.put(c,r++);

            int keys=map.size();


            if(keys==3){
                int deletIndex= Collections.min(map.values());


                map.remove(s.charAt(deletIndex));
                l=deletIndex+1;


            }

            max=Math.max(max, r-l);


        }

        return max;



    }

}
