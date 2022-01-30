package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    /**
     * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
     *
     * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
     *
     * Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
     *
     * Each range [a,b] in the list should be output as:
     *
     * "a->b" if a != b
     * "a" if a == b
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
     * Output: ["2","4->49","51->74","76->99"]
     * Explanation: The ranges are:
     * [2,2] --> "2"
     * [4,49] --> "4->49"
     * [51,74] --> "51->74"
     * [76,99] --> "76->99"
     * Example 2:
     *
     * Input: nums = [-1], lower = -1, upper = -1
     * Output: []
     * Explanation: There are no missing ranges since there are no missing numbers.
     */

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        // go thorugh the array
        // check i-1 is prev number i
        // if not check which in ranges , then add list

        List<String> ans=new ArrayList<String>();
        int prev=lower-1;

        for(int i=0;i<=nums.length;i++){

            int cur=(i<nums.length)?nums[i]:upper+1;

            if(prev+1<=cur-1){
                ans.add(formateRanges(prev+1,cur-1));
            }




            prev=cur;
        }


        return ans;

    }

    private String formateRanges(int min, int max){
        if(min==max){
            return String.valueOf(min);
        }
        return String.valueOf(min)+"->"+String.valueOf(max);

    }
}
