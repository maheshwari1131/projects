package com.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 * Accepted
 * 556,469
 * Submissions
 * 1,137,513
 */
public class MeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return a[0]-b[0];

            }

        });
        // Min Heap-Least value element will be removed first
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }



        });

        // add first meeting end time
        queue.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            //next meeting start time is >=end time the remove from q
            if(intervals[i][0]>=queue.peek()){
                queue.poll();
            }
            // add end time

            queue.add(intervals[i][1]);
        }

        return queue.size();

    }
}
