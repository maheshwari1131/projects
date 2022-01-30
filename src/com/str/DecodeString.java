package com.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class DecodeString {

    public static void main(String args[]){
        String s="3[a2[c]]";
        decodeString(s);
    }

    public static String decodeString(String s) {
        Stack<Character> stack=new Stack();
        StringBuilder buf=new StringBuilder();
        boolean stopBufS=false;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                List<Character> decodedString=new ArrayList<>();
                // get encoded string
                while(stack.peek()!='['){
                    decodedString.add(stack.pop());
                }
                // pop [ from the stack
                stack.pop();
                int base =1;
                int k=0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k=k+(stack.pop()-'0')*base;
                    base*=10;
                }
                // decode k[decodedString], by
                while(k!=0){
                    for(int j = decodedString.size() - 1; j >= 0; j--){
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
                stopBufS=false;
            }else{

                stack.push(s.charAt(i));
            }

        }

        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
