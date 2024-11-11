package com.javaProjectsBasic1.pkg1;

import java.util.ArrayList;
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

        System.out.println();
        System.out.println("Pattern Matcher find group --> mlist size ="+ mlist.size());
//        if(!mlist.isEmpty()) {
//            String el0 = mlist.get(0);
//            int numel0 = Integer.parseInt(el0);
//            int incrdnumel0=numel0+1;
//            System.out.println("incremented 0th element made into int type ="+incrdnumel0);
//        }
        for(int i=0; i<mlist.size();i++){
            System.out.println("mlist "+i+" index element ="+mlist.get(i));
        }

//        int[] arr={2, 10, 6, 5, 8,4, 19, 3};
//        int len=arr.length;
//        int[] tempB=new int[len];
//
//        for(int i=0; i<len; i++){
//            tempB[i]=arr[len-i-1];
//        }
    }

}
