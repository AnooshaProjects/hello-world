package com.javaProjectsBasic1.pkg1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTrials {
    public static void main(String[] args) {
        Pattern pattern= Pattern.compile("[a-d1-7]");

        Matcher matcher=pattern.matcher("a3");
        System.out.println("Does Input String have given regex pattern match1= "+matcher.find());

        Matcher matcher2=pattern.matcher("d1");
        System.out.println("Does Input String have given regex pattern match2= "+matcher2.find());

        Matcher matcher3=pattern.matcher("e1");
        System.out.println("Does Input String have given regex pattern match3= "+matcher3.find());

        Matcher matcher4=pattern.matcher("e8");
        System.out.println("Does Input String have given regex pattern match4= "+matcher4.find());

        Pattern pattern2= Pattern.compile("[abc]");
        Matcher matcher5=pattern2.matcher("ab");
        System.out.println("Does Input String have given regex pattern match5= "+matcher5.find());

        System.out.println("String matches(...) result1="+("d1".matches("[a-d1-7]")));
        System.out.println("String matches(...) result2="+("ab".matches("[abc]")));

        System.out.println("String matches(...) result1="+("b2".matches("[a-d1-7]")));
        System.out.println("String matches(...) result1="+("b2".matches("[a-d1-7]+")));
        System.out.println("String matches(...) result1="+("bc".matches("[a-d1-7]")));
        System.out.println("String matches(...) result1="+("a".matches("[a-d1-7]")));
        System.out.println("String matches(...) result1="+("e".matches("[a-d1-7]")));

    }
}
