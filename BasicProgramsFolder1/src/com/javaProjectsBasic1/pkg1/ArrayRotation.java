package com.javaProjectsBasic1.pkg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayRotation {

    public static void main(String[] args) {

        System.out.println("Enter array and num of rotations?");
        Scanner sc=new Scanner(System.in);
        String sin=sc.nextLine();

        //Pattern pattern=Pattern.compile("(\\d+)(\\s*)(\\]|,|)*(\\s*)");
        //Pattern pattern=Pattern.compile("[^\\s*()\\[\\],]+");
        Pattern pattern=Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(sin);

        List<String> mlist=new ArrayList<>();
        while(matcher.find()){
            mlist.add(matcher.group());
        }

        System.out.println("Pattern compile regex -> Pattern Matcher String -> matcher find group ---> mlist size ="+ mlist.size());
        if(!mlist.isEmpty()) {
            int numRots = Integer.parseInt(mlist.get(mlist.size() - 1));
            int lenArr=mlist.size()-1;
            int[] arr=new int[lenArr];
            for (int i = 0; i < lenArr; i++) {
                System.out.println("mlist "+i+" index element ="+mlist.get(i));
                arr[i]=Integer.parseInt(mlist.get(i));
            }

            System.out.println("Initial Given Array= "+Arrays.toString(arr));
            int[] rotatedArr=performRotationsSimpleWay(arr,numRots);
            System.out.println("----------------");
            System.out.println(Arrays.toString(rotatedArr));
            System.out.println("====================================");

            System.out.println("Initial Given Array= "+Arrays.toString(arr));
            int[] rotatedArrBetter1=performRotationsBetterWay1(arr,numRots);
            System.out.println("----------------");
            System.out.println(Arrays.toString(rotatedArrBetter1));
            System.out.println("====================================");
        }

    }

    private static int[] performRotationsBetterWay1(int[] arr, int numRots) {
        int len=arr.length;
        int[] tempArr1=new int[len];

        if(numRots==0 || (len%numRots)==0)
            return arr;

        int nRots=numRots%len;
        for(int i=0; i<len; i++){
            if(i<nRots){
                tempArr1[i]=arr[len-nRots+i];
            }
            else{
                tempArr1[i]=arr[i-nRots];
            }
        }

        return tempArr1;
    }

    private static int[] performRotationsSimpleWay(int[] A, int K) {

        int len=A.length;
        int[] tempB=new int[len];

        if(K==0 || ((len%K)==0))
            return A;

        int[] Acopy=Arrays.copyOf(A,len);

        for(int j=1; j<=K; j++) {
            tempB[0] = Acopy[len - 1];
            for (int i = 1; i < len; i++) {
                tempB[i] = Acopy[i - 1];
            }
            System.out.println("Iter "+j+" currArray= "+Arrays.toString(tempB));
            Acopy=Arrays.copyOf(tempB,len);
        }

        return tempB;
    }

}
