package com.arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // res list
        List<List<Integer>> res=new ArrayList<>();
        // sort array
        Arrays.sort(nums);

        //iterate through

        for(int i=0;i<nums.length;i++){
            // check duplicate condition
            if(i==0|| nums[i]!=nums[i-1]){
                int li=i+1;
                int ri=nums.length-1;
                while(li<ri){

                    int sum=nums[i]+nums[li]+nums[ri];
                    if(sum<0){
                        li++;
                    }else if(sum>0){
                        ri--;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[li],nums[ri]));
                        li++;
                        ri--;
                        //as li=i+1, to avoif duplicate in next iteration
                        while(li<ri && nums[li]==nums[li-1]){
                            ++li;
                        }

                    }
                }
            }
        }

        return res;

        //sum of 2 number use 2 pointer approce

        //if sum>0 then increment left pointer

        // sum <0 increment right pointer

        //  else add to list ie =0

    }
}

// Time Complexity -O(nlogn+n)->O(n2)
//Space Complexity--> On(N)