package com.javaProjectsBasic1.pkg1;

public class AddDiffTypes {
    public static void main(String[] args) {

        //NOTE1: You can get intValue or byteValue or doubleValue from Float type variable.
        Float f=new Float("3.0");
        int x=f.intValue();
        byte y=f.byteValue();
        double z=f.doubleValue();
        System.out.println("direct print sum of diff types ="+ (y+z+x));
        //NOTE2: When you directly do the addition in print itself, no need to worry about final result data type.
        //But, final result data type have to be correct/largest when adding different types as below.
        double sumDiffTypes = y + z + x;
        System.out.printf("Individual nums : %s, %s, %s | Final sum = %s",x,y,z, sumDiffTypes);
        System.out.println();

        //Adding string with numbers at beginning vs end.
        //NOTE3: All additions happen from left to right.
        //So, if first variable is String, everything else added after it will be considered String.
        //If 1st var is a num type & 2nd also num type, then they're added as numbers, till you get String type.
        //Once you get a String type, while going from left to right, from then on, all are just concatenated.
        String str1="Hello";
        String addWithStrAtStart= str1 + x + y;
        String addWithStrAtEnd = x + y + str1;
        System.out.println("Add numbers with string at the beginning ="+addWithStrAtStart); //Hello33
        System.out.println("Add numbers with string at the end ="+ addWithStrAtEnd); //6Hello

    }
}
