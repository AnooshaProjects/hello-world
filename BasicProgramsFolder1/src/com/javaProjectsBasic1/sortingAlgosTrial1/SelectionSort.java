package com.javaProjectsBasic1.sortingAlgosTrial1;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        //algo: 1) find the largest value of all elements and swap with right-most element.
        //Or, find the smallest value of all elements and swap with left-most element.
        //2) Then, repeat for each element in array.

        Random rand=new Random();
        int[] arr=new int[5];
        int l=arr.length;
        for (int i=0; i<l; i++) {
            arr[i] = rand.nextInt(100);
        }
        //[46, 66, 7, 53, 82]
        //int[] arr={46, 66, 7, 53, 82};
        //[94, 40, 48, 19, 78]
        //int[] arr={94, 40, 48, 19, 78};
        System.out.println("Before sort:");
        System.out.println(Arrays.toString(arr));

        selectionSort2Fors(arr);

        System.out.println("After sort:");
        System.out.println(Arrays.toString(arr));

    }

    private static void selectionSort2Fors(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1; j<arr.length; j++){
                //Note: min value and min Index BOTH keep changing inside this loop,
                //per each new value compared to existing min at that particular time.
                if(arr[j]<min){
                    minIndex=j;
                    min=arr[j];
                }
            }
            swap(arr, i, minIndex);
            //System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
