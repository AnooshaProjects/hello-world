package com.javaProjectsBasic1.pkg1;

public class PalindromeQReplace {

    public static String retPalindrome(String S, Integer K){

        int N=S.length();

        StringBuilder sb1 = new StringBuilder(S);

        int mid=N/2;
        int ct=0;
        if(N%2!=0){
            sb1.setCharAt(mid,'a');
        }
        //if(N%2==0){
            for(int i=0; i<mid; i++){
                if (sb1.charAt(i)=='?' && sb1.charAt(N-1-i)=='?'){
                    sb1.setCharAt(N-i-1,'a');
                    sb1.setCharAt(i, sb1.charAt(N-i-1));
                }
                else if(sb1.charAt(i)=='?' && sb1.charAt(N-1-i)!='?'){
                    sb1.setCharAt(i, sb1.charAt(N-1-i));
                }
                else if (sb1.charAt(N-1-i)=='?' && sb1.charAt(i)!='?'){
                    sb1.setCharAt(N-1-i, sb1.charAt(i));
                }
                else if (sb1.charAt(i)!='?' && sb1.charAt(N-1-i)!='?'
                && sb1.charAt(i)!=sb1.charAt(N-1-i)){
                    ct++;
                    if(ct<=K){
                        sb1.setCharAt(i, sb1.charAt(N-i-1));
                    }
                }
            }
        //}

        System.out.println("ct="+ct);
        StringBuilder sb2=new StringBuilder(sb1.toString());
        sb2.reverse();
        if((sb1.toString()).contentEquals(sb2)){
            return sb1.toString();

        }else
            return "NO";
    }

    public static void main(String[] args) {

        String in="a?b??a";
        int k=0;
        String result1 = retPalindrome(in, k);
        System.out.println("Result = "+result1);

        String in2="a?as??i???as?as??";
        int k2=3;
        String result2 = retPalindrome(in2, k2);
        System.out.println("Result = "+result2);

        String in4="a?as??i???as?as??";
        int k4=2;
        String result4 = retPalindrome(in4, k4);
        System.out.println("Result = "+result4);

        String in3="a?b??tyu?f???ghzsa";
        int k3=4;
        String result3 = retPalindrome(in3, k3);
        System.out.println("Result = "+result3);
    }
}
