package com.ksnapsack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given weights and values of n items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 *
 * In the 0-1 Knapsack problem, we are not allowed to break items. We either take the whole item or don’t take it.
 *
 * Input:
 * Items as (value, weight) pairs
 * arr[] = {{60, 10}, {100, 20}, {120, 30}}
 * Knapsack Capacity, W = 50;
 *
 * Output:
 * Maximum possible value = 240
 * by taking items of weight 10 and 20 kg and 2/3 fraction
 * of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240
 */
public class KnapSackIssue {

    static class Item implements Comparable<Item>{
        int value;
        int weight;
        double index;
        Double cost;
        public Item(int value, int weight, int index){
            this.value=value;
            this.weight=weight;
            this.index=index;
            cost=new Double((double)value/weight);
        }
        public int compareTo(Item o){
            return this.cost.compareTo(o.cost);
        }
    }

    public static void main(String[] args)
    {
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;

        double maxValue = getMaxValue(wt, val, capacity);

        // Function call
        System.out.println("Maximum value we can obtain = "
                + maxValue);
    }

    private static double getMaxValue(int[] wt, int[] val, int capacity) {

        Item[] ival=new Item[wt.length];
        for(int i=0;i<wt.length;i++){
            ival[i]=new Item(wt[i],val[i],i);
        }
        Arrays.sort(ival);

        double totalVal=0d;
        for(Item item:ival){
            int curWt=item.weight;
            int curVal=item.value;
            if(capacity-curWt>=0){
                capacity=capacity-curWt;
                totalVal+=curVal;
            }else{
                double fraction=((double)capacity/(double) curWt);
                totalVal+=curVal*fraction;
                capacity=(int)(capacity-curWt*fraction);
                break;
            }

        }

        return totalVal;

    }
}
