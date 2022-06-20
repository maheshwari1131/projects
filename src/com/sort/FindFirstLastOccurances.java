package com.sort;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class FindFirstLastOccurances {

    public static void main(String args[]){
        int nums[]={5,7,7,8,8,10};

        System.out.println(searchRange(nums, 6));
    }


    public static int[] searchRange(int[] nums, int target) {
        return findBound(nums,target,true);



    }

    private static int[] findBound(int[] nums, int target, boolean isFirst){
        int N=nums.length;
        int begin=0, end=N-1;
        while(begin<=end){
            int mid=(begin+end)/2;

            if(nums[mid]==target){

                int left=mid;
                int right =mid;
                while(left>0&& nums[left-1]==target){
                    left--;

                }
                while(right<N-1&& nums[right+1]==target){
                    ++right;

                }
                return new int[]{left,right};

            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                begin=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

}
