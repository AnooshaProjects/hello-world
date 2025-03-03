package com.javaProjectsBasic1.amazonProblemsTrialPkg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfNNumbersTrial1 {


    public static void main(String[] args) {
        List<Integer> inputList=new ArrayList<>();
        inputList.add(11);
        inputList.add(12);
        inputList.add(13);

        List<List<Integer>> finalOutputList = permutations(inputList);
        finalOutputList.forEach(PermutationsOfNNumbersTrial1::myPrint);
    }

    private static List<List<Integer>> permutations(List<Integer> inputList) {

        List<List<Integer>> listlist = new ArrayList<>();
        listlist.add(inputList);
        listlist.add(inputList);




        return listlist;
    }

    public static void myPrint(List<Integer> lst){
        Integer[] printArr = lst.toArray(new Integer[0]);
        System.out.println(Arrays.toString(printArr));
        //lst.stream().forEach((a)->mysingleprint(a));
    }

//    public static void mysingleprint(Integer a){
//        System.out.print(a+", ");
//    }


}
