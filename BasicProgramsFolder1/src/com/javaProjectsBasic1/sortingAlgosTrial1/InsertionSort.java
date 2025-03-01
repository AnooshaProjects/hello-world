package com.javaProjectsBasic1.sortingAlgosTrial1;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        //NOTE1: Sliding is the most important thing in insertion sort.
        //You keep sliding the elements to right till you find the right place for current element in hand.
        //
        //NOTE2: Algo: Take first element at 0th index. A single element is always sorted so, let it be for now.
        //Next, take 2nd el at 1st index into temp var, then compare it with previous element.
        //If previous el is greater than current el at index 1, it's not at correct position.
        //So, move/slide the previous el to right.
        //And put 2nd el at previous position.
        //Next, take 3rd element, compare with previous 2 elements, slide one-by-one to right based on comparison.
        //Then place the 3rd element to its correct position in this sorted part of array.
        //Next, take 4th element, compare it with previous 3 elements to insert it in correct position.
        //Next, repeat for all elements of array. Finally, all are inserted in correct locations.

        Random rand=new Random();
        int[] arr=new int[5];
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        for (int i=1; i< arr.length; i++){
            int j=i-1;
            int keyNow=arr[i];
            //Basically, compare all previous values with current element.
            //=> keep comparing each previous value with current element, and keep sliding greater values to right.
            //Stop when you find lesser or equal value at a previous location. That's where the curr el goes.
            while (j>=0 && arr[j]>keyNow){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=keyNow;
        }

        System.out.println(Arrays.toString(arr));

    }
}
