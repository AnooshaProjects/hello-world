package com.javaProjectsBasic1.pkg1;

import java.util.Scanner;

public class FibonacciVariousWays {

    public static void main(String[] args) {
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
        System.out.println("\n------------RecursionFib---------------");
        int n=10;
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
}
