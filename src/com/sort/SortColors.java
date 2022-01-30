package com.sort;

/**
 *   Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class SortColors {

    public void sortColors(int nums[]){
        int index=0;
        int low=0;
        int high=nums.length-1;
        while(index<=high){

            if(nums[index]==0){

                swap(nums,index, low);
                low++;
                index++;
            } else if(nums[index]==2){
                swap(nums,index,high);
                high--;
            }else{
                index++;
            }


        }

    }

    public void swap(int[] nums,int low, int index){
        int tmp=nums[low];
        nums[low]=nums[index];
        nums[index]=tmp;

    }
}
