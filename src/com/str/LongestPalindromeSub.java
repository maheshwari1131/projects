package com.str;

public class LongestPalindromeSub {
    public static void main(String[] args){
        String s=longestPalindrome("cbbd");
        System.out.println("Sub String="+s);

    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }



    public static String longestPalindromeNotCoveredEdgeCase(String s) {

        // Iterate over the string
        // at position left and right positions are same l--.r++
        // if not break take max sum array

        if(s.length()<1){
            return s;
        }
        System.out.println("Started "+s.length());
        String maxSub="";
        for(int i=1;i<s.length();i++){
            int l=i-1;
            int r=i==s.length()-1?i:i+1;
            String subS="";
            System.out.println("Befr l"+l);
            System.out.println("Before r"+r);
            while(l>=0&& r<s.length()-1){
                System.out.println("Curret l"+l);
                System.out.println("Curret r"+l);
                if(s.charAt(l)==s.charAt(r)){

                    subS=s.substring(l,r+1);
                    l--;
                    r++;

                }else{
                    System.out.println("else l"+l);
                    if(s.charAt(l)==s.charAt(i)){
                        System.out.println("Same l"+l);
                        subS=s.substring(l,i);

                    }
                    if(r!=i&&s.charAt(r)==s.charAt(i)){
                        System.out.println("Same r"+r);
                        subS=s.substring(i,r+1);
                        System.out.println("Same r"+subS);

                    }
                    break;

                }
            }
            maxSub=maxSub.length()>subS.length()?maxSub:subS;


        }
        return maxSub;

    }
}
