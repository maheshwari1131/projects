package com.arrays;

/**
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to the closest person.
 *
 * Input: seats = [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 *
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
  the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 */
public class MaxDistanceClosestPerson {

    public int maxDistToClosest(int[] seats) {                                                                                                                                                                                                                             // Iterate Through the array
// if s[i] ==1 ; prev=i-1
// if 0, get future full seat

// check left and right distance
// max of ans

        int n =seats.length;
        int prev=-1;
        int future=0;
        int ans=0;

        for(int i=0;i<n;i++){
            if(seats[i]==1){
// seat is full
                prev=i;

            }else{

                while(future<n && seats[future]==0|| future<i){
                    future++;
                }
                int left=prev==-1?n:i-prev;
                int right=future==n?n:future-i;
                int min=Math.min(left,right);
                ans=Math.max(ans,min);

            }

        }
        return ans;



    }
}
