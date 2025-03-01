package com.javaProjectsBasic1.sortingAlgosTrial1;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        //Divide & Conquer
        //Recursion
        //Pivot
        //Tree

        //Algo: (1)Take a pivot.
        //(2)Partition the array at the pivot by doing following:
        //Put all elements smaller than pivot value to the left-side of pivot location,
        //and all elements greater than pivot are placed to right-side of pivot.
        //This makes pivot to be in its correct place in array.
        //(3)Take the left partition/sub-array and again partition that,
        //so new pivot of this left sub-array is put in its correct place, and we get 2 new sub-sub-partitions.
        //(4)Then, take right partition/sub-array and again partition that, so its new pivot is at right place.
        //(5)Keep repeating all above steps until only 1 element is left => Nothing more to compare or sort.
        //(6)Combine all the results <-> well, they will already all be in their correct places, So, it's done!!

        Random rand=new Random();
        int[] arr= new int[5];
        for (int i=0; i<arr.length; i++){
            arr[i]=rand.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        //remember, quick sort uses recursion, so make a new method for it, which can then call itself.
        quicksort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    private static void quicksort(int[] arr, int lowIndex, int highIndex) {
        
        //1. Do partition based on pivot value.
        //2. Recursively sort left sub-array.
        //3. Then, recursively sort right sub-array.

        //NOTE1: lowIndex & highIndex are sub-array's first & last elements for every recursion, after 1st main.
        //But also, lowIndex and highIndex are indexes referring to the main full array locations.
        //=>lowIndex and highIndex give the part of main array that we're considering as current working sub-array.
        //NOTE2: For recursive calls to work, you always check lowIndex is less than equal to high Index.
        //NOTE4: IMP: Only highIndex keeps changing for only left-most sub-branches of the main big tree,
        //and only lowIndex keeps changing for only right-most sub-branches of the main big tree.
        //If you see right sub-sub-branch of a left sub-branch, it's low and high indexes both change.
        //||ly, if you see any left sub-sub-branch of a right sub-branch, it's low and high indexes both change.
        if(lowIndex<highIndex){
            int pivotCorrectLocation=partitionPerPivot(arr,lowIndex,highIndex);
            quicksort(arr, lowIndex, pivotCorrectLocation-1);
            quicksort(arr, pivotCorrectLocation+1, highIndex);
        }
        //NOTE5: Note that all our calls are within the if condition.
        //So, this will return back to calling method correctly, and eventually to main method when all done.

    }

    private static int partitionPerPivot(int[] arr, int lowIndex, int highIndex) {
        //NOTE3: lowIndex and highIndex are original array index locations, but current sub-array's first & last.
        //choose pivot = end element of current sub-array.
        //All elements lower than pivot value are moved to left-most available locations of current sub-array.
        int pivot=arr[highIndex];
        int i=lowIndex-1;
        int j=lowIndex;
        while(j<highIndex){
            if(arr[j]<pivot){
                i=i+1;
                swapVals(arr,i, j);
            }
            j++;
        }
        swapVals(arr, (i+1), highIndex);

        return i+1;
    }

    private static void swapVals(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
