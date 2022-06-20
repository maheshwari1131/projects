package com.sort;

import java.util.*;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Example 2:
 *
 * Input: nums = [-1]
 * Output: [0]
 * Example 3:
 *
 * Input: nums = [-1,-1]
 * Output: [0,0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * Accepted
 * 216,298
 * Submissions
 * 514,145
 */
public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        int offset = 10000; // offset negative to non-negative
        int size = 2 * 10000 + 2; // total possible values in nums plus one dummy
        int[] tree = new int[size];
        List<Integer> result = new ArrayList<Integer>(nums.length);
        result.get(0)

        for (int i = nums.length - 1; i >= 0; i--) {
            int smaller_count = query(nums[i] + offset, tree);
            result.add(smaller_count);
            update(nums[i] + offset, 1, tree, size);
        }
        Collections.reverse(result);
        return result;
    }

    // implement Binary Index Tree
    private void update(int index, int value, int[] tree, int size) {
        index++; // index in BIT is 1 more than the original index
        while (index < size) {
            tree[index] += value;
            index += index & -index;
        }
    }

    private int query(int index, int[] tree) {
        // return sum of [0, index)
        int result = 0;
        while (index >= 1) {
            result += tree[index];
            index -= index & -index;
        }
        return result;
    }

    public void countSmaller1(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=map.getOrDefault(nums[i], 0);


        }
       // return map;

    }
}
