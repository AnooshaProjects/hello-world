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

        List<List<Integer>> finalOutputList = new ArrayList<>();
        myPermutations(finalOutputList, inputList);
        finalOutputList.forEach(PermutationsOfNNumbersTrial1::myPrint);
    }

    private static void myPermutations(List<List<Integer>> currOutList, List<Integer> inputList) {

        List<List<Integer>> listlist = new ArrayList<>();

        if(inputList.size()==1) {
            currOutList.add(inputList);
            //return listlist;
        } else if(inputList.size()==2) {
            List<Integer> list2vals=new ArrayList<>();
            list2vals.add(inputList.get(0));
            list2vals.add(inputList.get(1));
            List<Integer> list2valsSwapped=new ArrayList<>();
            list2valsSwapped.add(inputList.get(1));
            list2valsSwapped.add(inputList.get(0));
            currOutList.add(list2vals);
            currOutList.add(list2valsSwapped);
            //return listlist;
        } else {
            for (Integer a : inputList) {
                List<Integer> newPList = new ArrayList<>(inputList);
                newPList.remove(a);
                System.out.println("newPList size= "+newPList.size());
                myPermutations(currOutList, newPList);
                currOutList.forEach((eachPermAsList)-> eachPermAsList.add(0,a));
            }
        }

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
