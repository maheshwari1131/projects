package com.arrays;

import java.lang.*;
import java.util.Map;

class MultiplyString {


    public static void main(String args[]) {

        String n1 = "12";
        String n2 = "13";

        String out = multiplyNumbers(n1, n2);
    }

    private static String multiplyNumbers(String num1, String num2) {

        // check which num is length is less , multiple with that number, so that number

        // multiple digitais

        // ech chr multiple

        // result=n/10
        //carr=n%10

        if(num1.isEmpty() || num2.isEmpty()|| num1.equals("0")||num2.equals("0")){

            return "0";
        }

        StringBuffer fn=new StringBuffer(num1);
        StringBuffer sn=new StringBuffer(num2);

        fn.reverse();
        sn.reverse();

        // to Store Multiplition Result of each digit of second with first number

        int n=num1.length()+num2.length();
        StringBuilder a=new StringBuilder();

        for(int i=0;i<n;i++){
            a.append(0);
        }

        System.out.println("a"+a);
        for(int p2=0;p2<sn.length();p2++){

            int d2=sn.charAt(p2)-'0';

            for(int p1=0;p1<fn.length();p1++){

                int d1=fn.charAt(p1)-'0';
                // the number of zeros from multiplying to digits depends on the place of digits2 in second number and place of the digit1 in firstNumber

                int cPo=p1+p2;
                int carry =a.charAt(cPo)-'0';
                int mul=d1*d2+carry;
                a.setCharAt(cPo,(char)(mul%10+'0'));

                //carry the tens place of multiplication result

                //adding it to next position in the answer

                int val=(a.charAt(cPo+1)-'0')+mul/10;
                a.setCharAt(cPo+1,(char)(val+'0'));


            }


        }

        //pop excess 0 from rear of answer

        if(a.charAt(a.length()-1)=='0'){
            a.deleteCharAt(a.length()-1);
        }

        a.reverse();

        return a.toString();




    }

}
