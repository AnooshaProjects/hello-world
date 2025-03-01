package com.javaProjectsBasic1.sortingAlgosTrial1;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={9,2,1};

        //NOTE: After each outer loop iteration, highest value bubbles to the end/last index.
        for(int i=(arr.length - 1); i>=1; i--){
            for (int j=0; j<i; j++){
                //swap each adjacent pair, putting the higher value of the 2 to the right
                //so, bubble the higher value of each 2 adjacent values to the right.
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
