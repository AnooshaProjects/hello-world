package com.javaProjectsBasic1.pkg1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTrials {
    public static void main(String[] args) {

        Pattern pattern= Pattern.compile("[a-d1-7]");

        System.out.println("RegExp. = [a-d1-7]");
        Matcher matcher=pattern.matcher("a3");
        System.out.println("a3 input string Pattern Matcher find()= "+matcher.find());

        Matcher matcher2=pattern.matcher("d1");
        System.out.println("d1 input string Pattern Matcher find()= "+matcher2.find());

        Matcher matcher3=pattern.matcher("e1");
        System.out.println("e1 input string Pattern Matcher find()=  "+matcher3.find());

        Matcher matcher4=pattern.matcher("e8");
        System.out.println("e8 input string Pattern Matcher find()= "+matcher4.find());

        System.out.println("------------------------------------");
        String regex="[abc]";
        String str="ab";
        System.out.println("RegEx Pattern Compile = "+regex);
        Pattern pattern2= Pattern.compile(regex);
        Matcher matcher5=pattern2.matcher(str);
        System.out.printf("%s input string Pattern Matcher find()= %s\n", str, matcher5.find());
        System.out.printf("%s input string Pattern Matcher matches()= %s\n", str, matcher5.matches());
        //NOTE: find() method returns true if any substring contains the regex type of pattern.
        //BUT, matches() is true ONLY if WHOLE input string matches the given regex EXACTLY!!
        String str2="a";
        Matcher matcher6=pattern2.matcher(str2);
        System.out.printf("%s input string Pattern matcher matches()= %s\n", str2, matcher6.matches());

        //-------------------------------------------------------------------------------
        System.out.println("=================================================");
        System.out.println("=====String matches(regex,inp) method=============");
        //NOTE: String str.matches(regex) => String matches matches WHOLE string only!!!
        System.out.println("ab String.matches(...) [abc] result= "+ ("ab".matches("[abc]")));
        System.out.println("d1 String.matches(...) [a-d1-7] result= "+ ("d1".matches("[a-d1-7]")));
        System.out.println("b2 String.matches(...) [a-d1-7] result= "+ ("b2".matches("[a-d1-7]")));
        System.out.println("b2 String.matches(...) [a-d1-7]+ result= "+ ("b2".matches("[a-d1-7]+")));
        System.out.println("bd String.matches(...) [a-d1-7]+ result= "+ ("bd".matches("[a-d1-7]+")));
        System.out.println("bf String.matches(...) [a-d1-7]+ result= "+ ("bf".matches("[a-d1-7]+")));
        System.out.println("bc String.matches(...) [a-d1-7] result= "+ ("bc".matches("[a-d1-7]")));
        System.out.println("a String.matches(...) [a-d1-7] result= "+ ("a".matches("[a-d1-7]")));
        System.out.println("e String.matches(...) [a-d1-7] result= "+ ("e".matches("[a-d1-7]")));
        //NOTE: String replace(...) uses LITERAL, whereas replaceAll(...) uses RegExp.
        System.out.println("=====String replace(existingStr,newStr) method=============");
        System.out.println("abc123ab".replace("ab","hello"));
        System.out.println("=====String replaceAll(regex,newStr) method=============");
        System.out.println("abc123ab".replaceAll("[ab]","hello"));
        System.out.println("**************************************************");

        System.out.println("------*************************------");

        String inp="geekblahblah4567";
        System.out.println("INPUT = "+inp);
        Pattern pbGroups=Pattern.compile("(geeks[0-9]+).(for[1-5]*)");
        Matcher mblahhGroups= pbGroups.matcher(inp);
        System.out.println("matcher mblahhGroups groupCount= "+mblahhGroups.groupCount());
        //NOTE: matcher.groupCount() gives group count in the RegEx itself, not in the input string.
//        System.out.println("grp0= "+mblahhGroups.group(0));
//        System.out.println("grp1= "+mblahhGroups.group(1));
//        System.out.println("grp2= "+mblahhGroups.group(2));

        System.out.println("------*************************------");

        System.out.println(Pattern.matches("geeks[0-9]*","geeks"));

        System.out.println(Pattern.matches("geeks[0-9]+","geeks"));
        System.out.println(Pattern.matches("geeks[0-9]+","geeks1"));
        System.out.println(Pattern.matches("geeks[0-9]+","geeks12b"));
        Pattern pt=Pattern.compile("geeks[0-9]+");
        Matcher mr= pt.matcher("geeks12bgeeks8abcd");
        System.out.println("matcher mr groupCount= "+mr.groupCount());
        //System.out.println("matcher find() = "+mr.find());
        //System.out.println("matcher group(1) = "+mr.group(1));

        while(mr.find()){
            System.out.println("In if, group is= "+mr.group(0));
        }
        System.out.println("matcher mr groupCount= "+mr.groupCount());
        //System.out.println("Outside if, matcher mr group() = "+mr.group());
        //NOTE: Above group(0) call which is OUTSIDE while(find()) loop gives ERROR!!
        //So use mtr.group() or mtr.group(0) etc methods inside while(find()) ONLY!!!
        System.out.println("matcher mr groupCount= "+mr.groupCount());

        System.out.println("------Next Pattern RegEx Groups------");
        Pattern pGroups=Pattern.compile("(geeks[0-9]+).(for[1-5]*)");
        Matcher mGroups= pGroups.matcher("geeks12bforxxxxxgeeks8pfor52689yyygeeks3!for22geeksgeeksgeeks");
        System.out.println("matcher mGroups groupCount= "+mGroups.groupCount());//2
        int ctFinds=0;
        while(mGroups.find()){
            ctFinds++;
            System.out.println("In if, group(0) is= "+mGroups.group(0)
                    +" | group(1)= "+mGroups.group(1)
                    +" | group(2)= "+mGroups.group(2)
                    +" | group()= "+mGroups.group());
        }
        System.out.println("matcher groupCount= "+mGroups.groupCount());
        System.out.println("matcher ctFinds= "+ctFinds); //3
        //System.out.println("matcher group() = "+mGroups.group()); //==> gives ERROR!!!
        //NOTE: Do NOT use group() method outside find()'s if/while conditions.

        System.out.println("------*************************------");

    }
}
