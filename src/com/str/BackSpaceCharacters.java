package com.str;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackSpaceCharacters {

    public static void main(String args[]){

        backspaceCompare("y#fo##f","y#f#o##f");
    }

    public boolean backspaceCompare1(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    public static boolean backspaceCompare(String s, String t) {


        StringBuffer buf1=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(buf1.length()!=0){

                    buf1.deleteCharAt(buf1.length()-1);

                }


            }else{
                buf1.append(s.charAt(i));
            }
        }
        StringBuffer buf2=new StringBuffer();
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if( buf2.length()!=0){
                    buf2.deleteCharAt( buf2.length()-1);
                }



            }else{
                buf2.append(t.charAt(i));
            }
        }

        return buf1.toString().equals(buf2.toString());

        //time O(N+M)

    }
}
