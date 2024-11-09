package com.javaProjectsBasic1.pkg1;

import java.util.Scanner;

public class FibonacciVariousWays {

    public static void main(String[] args) {
        System.out.println("FibonacciVariousWays.main");

        System.out.println("------------NormalWayFib---------------");
        fibonacciNormalWay();

        System.out.println("\n------------RecursionFib---------------");
        fibonacciRecursiveWay();

        System.out.println("\n------------DynamicProgrammingFib---------------");
        fibonacciDynamicWay();

        System.out.println("\n======Fibonacci3WaysDone=================");
    }

    public static void fibonacciNormalWay() {
        System.out.println("Enter till which Fibonacci number you want the series?");
        Scanner sc=new Scanner(System.in);
        int fNumsTill = sc.nextInt();
        int num1=0;
        int num2=1;
        int currFNum=0;
        System.out.print(num1+" "+num2);
        while(currFNum<fNumsTill){
            currFNum=num1+num2;
            System.out.print(" "+currFNum);
            num1=num2;
            num2=currFNum;
        }
    }

    public static void fibonacciRecursiveWay() {
        System.out.println("How Many Fibonacci numbers in Recursive way?");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i=0; i<n; i++) {
            int fnum = fib(i);
            System.out.print(fnum+" ");
        }
    }

    public static int fib(int n){
        if(n<=1)
            return n;

        return fib(n-1)+fib(n-2);
    }


    public static void fibonacciDynamicWay() {
        System.out.println("How Many Fibonacci numbers in Dynamic way?");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] fibMemo = new int[n];

        fibMemo[0]=0;
        fibMemo[1]=1;
        System.out.print(fibMemo[0]+" "+fibMemo[1]);
        for (int i=2; i<n; i++){
            fibMemo[i]=fibMemo[i-1]+fibMemo[i-2];
            System.out.print(" "+fibMemo[i]);
        }
    }
}
