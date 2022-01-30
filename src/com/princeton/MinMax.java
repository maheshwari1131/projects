package com.princeton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Read in integers from standard input and print out the maximum and
 *  *  minimum values.
 */
public class MinMax {
    public static void main(String [] args) throws IOException {
        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
        String name=read.readLine();

        System.out.println("Name"+name);
        Scanner sc=new Scanner(System.in);
        int max=sc.nextInt();
        System.out.println("Max va"+ max);

    }
}
