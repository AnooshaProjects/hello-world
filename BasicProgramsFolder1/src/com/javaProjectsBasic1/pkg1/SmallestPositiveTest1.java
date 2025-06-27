package com.javaProjectsBasic1.pkg1;

import java.util.Arrays;

public class SmallestPositiveTest1 {

    public int solution(int[] A) {
        // Implement your solution here
        if (A==null)
            return 1;

        if (A.length <1 || A.length>100000)
            return 1;

        for (int el : A){
            if (el<-1000000 || el>1000000)
                return 1;
        }

        int[] Ac = Arrays.copyOf(A, A.length);

        Arrays.sort(Ac);

        boolean noneInA=true;
        boolean allNeg=true;
        boolean exists1=false;
        for(int i=0 ; i<Ac.length-1; i++){
            if(Ac[i]>0){
                allNeg=false;
                if(Ac[i]==1)
                    exists1=true;

                if(Ac[i+1]-Ac[i] > 1){
                    noneInA=false;
                    return Ac[i]+1;
                }
            }

        }

        if(allNeg || !exists1)
            return 1;

        if(noneInA)
            return Ac[Ac.length - 1]+1;

        return 1;
    }

    public static void main(String[] args) {
        int[] A={1, 3, 6, 4, 1, 2};
        SmallestPositiveTest1 ex1=new SmallestPositiveTest1();
        int smallestPositiveNotInA = ex1.solution(A);
        System.out.println("smallestPositiveNotInA = "+smallestPositiveNotInA);

    }
}
