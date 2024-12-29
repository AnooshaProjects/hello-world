package com.javaProjectsBasic1.pkg1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTrials {
    public static void main(String[] args) {

        Pattern pattern= Pattern.compile("[a-d1-7]");

        System.out.println("RegExp. = [a-d1-7]");
        Matcher matcher=pattern.matcher("a3");
        System.out.println("a3 input string Pattern Matcher = "+matcher.find());

        Matcher matcher2=pattern.matcher("d1");
        System.out.println("d1 input string Pattern Matcher = "+matcher2.find());

        Matcher matcher3=pattern.matcher("e1");
        System.out.println("e1 input string Pattern Matcher =  "+matcher3.find());

        Matcher matcher4=pattern.matcher("e8");
        System.out.println("e8 input string Pattern Matcher = "+matcher4.find());

        System.out.println("--------------------");
        Pattern pattern2= Pattern.compile("[abc]");
        System.out.println("RegEx Pattern Compile = [abc]");
        Matcher matcher5=pattern2.matcher("ab");
        System.out.println("ab input string Pattern Matcher = "+matcher5.find());

        //-------------------------------------------------------------------------------
        System.out.println("=========================================");
        System.out.println("ab String.matches(...) [abc] result="+("ab".matches("[abc]")));
        System.out.println("d1 String.matches(...) [a-d1-7] result="+("d1".matches("[a-d1-7]")));
        System.out.println("b2 String.matches(...) [a-d1-7] result="+("b2".matches("[a-d1-7]")));
        System.out.println("b2 String.matches(...) [a-d1-7]+ result="+("b2".matches("[a-d1-7]+")));
        System.out.println("bf String.matches(...) [a-d1-7]+ result="+("bf".matches("[a-d1-7]+")));
        System.out.println("bc String.matches(...) [a-d1-7] result="+("bc".matches("[a-d1-7]")));
        System.out.println("a String.matches(...) [a-d1-7] result="+("a".matches("[a-d1-7]")));
        System.out.println("e String.matches(...) [a-d1-7] result="+("e".matches("[a-d1-7]")));
        System.out.println("=========================================");

    }
}
