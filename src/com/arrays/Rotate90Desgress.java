package com.arrays;

public class Rotate90Desgress {

    public void rotateArray(int a[][]){
        if(a.length==0 ||a[0].length==0){
            return;
        }
        //a[row][colum]

        transposeArray(a);
        reverseArray(a);


    }

    private void reverseArray(int[][] a) {
        int n=a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int t=a[i][j];
                a[i][j]=a[i][n-j-1];
                a[i][n-j-1]=t;
            }
        }
    }

    private void transposeArray(int[][] a) {
        int n=a.length;


        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int t=a[j][i];
                a[j][i]=a[i][j];
                a[i][j]=t;
            }
        }
    }

}
