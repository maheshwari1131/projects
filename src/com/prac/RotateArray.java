package com.prac;

public class RotateArray {

    public static void main(String args[]){

        int a[]={1,2,3,4,5};
        int d=4;
        //srotateArrayLeft(a, d);

        int b[][]={{1,2,3},{4,5,6},{7,8,9}};

        // expected out-->7,4,1}


        rotate2DArray90Deg(b);
    }

    private static void rotate2DArray90Deg(int[][] b) {

        // transepose array, first row->first column-> but swap only upper triangle
        int n=b.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){ // only uper traingle , so j is strting from i
                int temp=b[i][j];
                b[i][j]=b[j][i];
                b[j][i]=temp;
            }
        }

        // reverse columns

        for(int i=0;i<n;i++){
            int li=0;
            int ri=n-1;
            while(li<ri){
                int temp=b[i][li];
                b[i][li]=b[i][ri];
                b[i][ri]=temp;
                li++;
                ri--;
            }
        }

        displayArray(b);
    }

    private static void displayArray(int[][] b) {
        int n=b.length;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j]+",");
            }
            System.out.println(" ");
            }
        }

    private static int[] rotateArrayLeft(int[] a, int d) {
        int l=a.length;
        int temp[]=new int[l];
        int j=0;
        for(int i=d;i<l;i++,j++){

            temp[j]=a[i];
        }
        if(l>j){
            for(int i=0;i<d;i++,j++){
                temp[j]=a[i];
            }
        }
        return temp;
    }


}
