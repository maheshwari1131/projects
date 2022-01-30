package com.arrays;
import java.util.Arrays;

public class FindandReplaceString {

    /**
     * Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
     * Output: "eeebffff"
     * Explanation:
     * "a" occurs at index 0 in s, so we replace it with "eee".
     * "cd" occurs at index 2 in s, so we replace it with "ffff".
     *
     * Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
     * Output: "eeecd"
     * Explanation:
     * "ab" occurs at index 0 in s, so we replace it with "eee".
     * "ec" does not occur at index 2 in s, so we do nothing.
     * @param args
     */

    public static void main(String [] args){
        int[] in={2,2};
        String[] s={"a","cd"};
        String [] t={"eee","ffff"};

        System.out.println(findReplaceString("abcd",in,s,t));

    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n=s.length();
        int[] matches=new int[n];
        Arrays.fill(matches,-1);

        for(int i=0;i<indices.length;i++){
            int index=indices[i];
            System.out.println("index="+index);
            System.out.println("sources[i]="+sources[i]);
            int t=indices[i]+sources[i].length();
            System.out.println("t="+t);

            System.out.println("subString="+s.substring(indices[i],indices[i]+sources[i].length()));

            if(s.substring(indices[i],indices[i]+sources[i].length()).equals(sources[i])){
                System.out.println("match dound");
                matches[index]=i;


            }
        }

        StringBuilder res=new StringBuilder();
        int i=0;

        while(i<n){
            if(matches[i]!=-1){
                res.append(targets[matches[i]]);
                i+=sources[matches[i]].length();
            }else{
                res.append(s.charAt(i));
                i++;
            }

        }
        return res.toString();


    }
}
