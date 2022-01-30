package com.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        int mSize=(nums.length)/2;

        int ans=0;

        if(nums.length<2){
            return nums[0];
        }

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){


                int count=map.get(nums[i]);

                map.put(nums[i],++count);
                if(count>mSize){

                    return nums[i];
                }

            }else{

                map.put(nums[i],1);

            }




        }

        return ans;

    }

    public int majorityElement(final List<Integer> A) {
        int ans;
        int major=A.get(0);
        int count=1;

        for(int i=1;i<A.size();i++){
            if(count==0){
                major=A.get(i);
                count++;
            }
            if(A.get(i)==major)count++;

            if(A.get(i)!=major) count--;


        }

        ans=major;


        return ans;
    }
}
