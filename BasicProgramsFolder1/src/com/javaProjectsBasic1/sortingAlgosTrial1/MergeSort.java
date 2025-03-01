package com.javaProjectsBasic1.sortingAlgosTrial1;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        //Divide & Conquer
        //Algo: (A)Break to sub-arrays, just based on just mid positions.
        //(B)Main logic to SORT and COMBINE happens during the merging part of the algo.

        /*
        FINAL NOTE: SUMMARY:
        Merge Sort - Divide & Conquer -> Divide just based on mid locations,
        but then while re-combining them, we compare and combine in correct order of values,
        and keep going up the tree.
        */

        Random rand= new Random();
        int[] arr=new int[5];
        for(int i=0; i<arr.length; i++){
            arr[i]=rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));

        mergesort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    private static void mergesort(int[] arr, int l, int r) {

        //Main algo:
        //(I) Calculate mid index.
        //(II) Keep on dividing till we get to single elements.
        //(III) Then, combine left and right sub-arrays in numerical order of the values.

        if(l<r){

            int mid=(l+r)/2;
            mergesort(arr,l,mid);
            mergesort(arr,mid+1,r);
            myMerge(arr,l,mid,r);
            //NOTE: For the main merging logic, we just pass in the whole main array, & current l,r and mid indexes.
            //Actually creating new working sub-arrays, comparing values and combining is all done in the last call.

        }

    }

    private static void myMerge(int[] arr, int l, int mid, int r) {
        //This is actual merging logic which compares el values and merges accordingly.

        //1) We need to create new left sub-array and new right sub-array,
        //and populate them with the correct values from original array using the original indexes l and r and mid,
        //so that we can easily work with comparing and combining the new/fresh sub-arrays.
        //Then we can place the ordered values into the original array at their right locations itself,
        //since we know which 2 adjacent sub-parts of the main array we just dealt with and sorted.

        //(i)determine sizes of the new sub-arrays.
        int n1=mid-l+1;
        int n2=r-mid;

        int[] lArr=new int[n1];
        int[] rArr=new int[n2];

        //(ii)fill the new sub-arrays with actual values from the parent array.
        for(int x=0; x<n1; x++) {
            lArr[x] =arr[l+x];
        }
        for (int y=0; y<n2; y++){
            rArr[y]= arr[mid+1+y];
        }

        //2) Combine/merge the 2 new sub-arrays in the correct sorted order.
        //To form the logic, take 2 specific sub-arrays for example, and solve the combining logic for that,
        //because, the same logic repeats for each 2 sub-arrays being combined.
        int i=0;
        int j=0;
        //i and j are moving pointers, that move along left sub-array and right sub-array respectively.
        int k=l;
        //NOTE: We want the location where to start placing ordered values in main array.
        //Since we know l and r are the indexes of the main array,
        //which indicate the sub-part of the main array that we will currently deal with in this call,
        //so then, k starts with original left=l, and keeps incrementing while putting the newly-ordered value.
        //NOTE: IMP:
        //Remember, Firstly, we are looking at l to r sub-array,
        //and ordering the elements inside it by comparing its 2 sub-parts based on mid,
        //which for working out purposes, we will place into 2 new arrays, leftArray and rightArray,
        //and Lastly, we are placing the ordered values back into main array from l to r.
        //NOTE:
        //Which l to r do we need to look at currently, is always decided by the preceding dividing logic.
        //So, before each merge, we have the correspondingly divided left and right parts.
        //NOTE:
        //=>This merge logic happens for every 2 adjacent parts, going up the tree, till final halves of original.
        while (i<n1 && j<n2){
            if(lArr[i]<=rArr[j]){
                arr[k]=lArr[i];
                i++;
            } else {
                arr[k]=rArr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=lArr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=rArr[j];
            j++;
            k++;
        }

    }
}
