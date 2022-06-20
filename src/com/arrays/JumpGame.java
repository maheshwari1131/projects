package com.arrays;
//*
//You are given an integer array nums. You are initially positioned at the array's first index,
// and each element in the array represents your maximum jump length at that position.
public class JumpGame {

    public static void main(String args[]){
        int a[]={3,2,1,0,4};
        System.out.println(canJump(a));
    }

    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }


    public static boolean canJump1(int[] nums) {

        if(nums.length==0||nums.length==1){
            return false;
        }

        int pointer=0;
        //[3,2,1,0,4]


        while(pointer<nums.length){


            int data=nums[pointer];


            pointer=Math.min(pointer+data, nums.length-1);
            if(pointer==nums.length-1){
                return true;
            }

            if(pointer<=0||pointer>nums.length|| data==0){
                break;
            }




        }

        return false;


    }
}
