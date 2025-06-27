package com.javaProjectsBasic1.pkg1;

import java.util.*;

public class SumOfParts2Arrays {

    public static Integer[] retCountOfSameSumPartitions(int[] A, int[] B){

        int N=A.length;
        int s11, s12, s21, s22;
        List<Integer> splits =new ArrayList<>();
        for (int i=1; i<N; i++){
            s11=0; s12=0; s21=0; s22=0;
            System.out.println("Split at: "+i);
            for(int j = 0; j <i; j++){
                s11=s11+A[j];
                s21=s21+B[j];
            }
            for(int k = i; k <N; k++){
                s12=s12+A[k];
                s22=s22+B[k];
            }

            System.out.printf("s11=%d, s21=%d",s11,s21);
            System.out.println();
            System.out.printf("s12=%d, s22=%d",s12,s22);
            System.out.println();
            System.out.println("-----------");
            if(s11==s21 && s12==s22 && s12==s21){
                splits.add(i);
            }
        }

        return splits.toArray(new Integer[0]);
    }

    public static Integer[] retCountOfSameSumPartitionsFaster(int[] A, int[] B){

        int N=A.length;
        int s11, s12, s21, s22;
        List<Integer> splits1 =new ArrayList<>();
        List<Integer> splits2 =new ArrayList<>();
        List<Integer> splits3 =new ArrayList<>();

        //ArrayList<Integer> AIncCts=new ArrayList<>();
        Map<Integer,Integer> map1Left=new HashMap<>();
        Map<Integer,Integer> map1Right=new HashMap<>();

        Map<Integer,Integer> map2Left=new HashMap<>();
        Map<Integer,Integer> map2Right=new HashMap<>();

        map1Left.put(0,A[0]);
        map1Right.put(N-1,A[N-1]);

        map2Left.put(0,B[0]);
        map2Right.put(N-1,B[N-1]);
        for(int i=1; i<N; i++){
            int sALeft=map1Left.get(i-1)+ A[i];
            map1Left.put(i,sALeft);

            int sARight=map1Right.get(N-i) + A[N-i-1];
            map1Right.put(N-i-1,sARight);

            int sBLeft =map2Left.get(i-1)+ B[i];
            map2Left.put(i, sBLeft);

            int sBRight =map2Right.get(N-i) + B[N-i-1];
            map2Right.put(N-i-1, sBRight);
        }

        for(int i=0; i<N-1; i++){
            if (
                    Objects.equals(map1Left.get(i), map1Right.get(i + 1))
            ) {
                splits1.add(i + 1);
            }
            if (
                    Objects.equals(map2Left.get(i), map2Right.get(i + 1))
            ) {
                splits2.add(i + 1);
            }
            if (
                    Objects.equals(map1Left.get(i), map1Right.get(i + 1))
                            && Objects.equals(map2Left.get(i), map2Right.get(i + 1))
                            && Objects.equals(map1Left.get(i), map2Left.get(i ))
            ) {
                splits3.add(i + 1);
            }
        }

//        System.out.println("Splits1: "+splits1.toString());
//        System.out.println("Splits2: "+splits2.toString());
//        System.out.println("Splits3: "+splits3.toString());

        return splits3.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
//        int[] A={0,4,-1,0,3};
//        int[] B={0,-2,5,0,3};

        int[] A={2, -2, -3, 3};
        int[] B={0, 0, 4, -4};

        Integer[] result=retCountOfSameSumPartitionsFaster(A,B);
        System.out.println(Arrays.toString(result));
    }
}
