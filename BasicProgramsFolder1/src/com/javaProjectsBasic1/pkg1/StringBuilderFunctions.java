package com.javaProjectsBasic1.pkg1;

public class StringBuilderFunctions {

    public static void main(String[] args) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder(50);

        StringBuilder sb = new StringBuilder("GeeksForGeeks");
        //modifies the string in place, does not create new object for changes.
        //Best used in single-threaded applications as it is not synchronized.

        //1. length //2.capacity
        int sbLength=sb.length();
        int sbCapacity= sb.capacity();
        System.out.printf("sb | length=%6f | capacity=%6f", sbLength+0.5, sbCapacity+0.5);
        System.out.println();

        //3. toString
        System.out.println("String sb = "+sb.toString());

        //4. append
        sb.append("Courses");
        System.out.println("sb append Courses result= "+sb);

        //5. insert
        sb.insert(2,"Hey");
        System.out.println("sb insert-Hey result = "+sb );

        //6. replace
        int rstrt=6;
        int rendt =10;
        sb.replace(rstrt, rendt, "SaintTyagaraj");
        System.out.printf("sb replace %d,%d,Saint result = %s",rstrt, rendt,sb );
        System.out.println();

        //7. delete
        int dstrt=2;
        int dendt=5;
        sb.delete(dstrt,dendt);
        System.out.printf("sb delete %d,%d,Saint result = %s",dstrt, dendt,sb );
        System.out.println();

        //8. chartAt
        int chrat=3;
        System.out.printf("sb charAt %d = %s", chrat, sb.charAt(chrat));
        System.out.println();

        //9. setCharAt
        int setchrIdx = 6;
        char chr='j';
        sb.setCharAt(setchrIdx, chr);
        System.out.printf("sb.setCharAt index=%d newchar=%s result = %s",setchrIdx, chr, sb );
        System.out.println();

        //10. deleteCharAt
        int delchrIdx=4;
        sb.deleteCharAt(delchrIdx);
        System.out.printf("sb.deleteCharAt index=%d result = %s",delchrIdx, sb );
        System.out.println();

        //11. reverse
        System.out.println("sb reverse = "+sb.reverse());
        //Q1) Did sb itself change in-place with the reverse call? Is original sb object itself reversed?
        //A1) Yes, sb itself has changed permanently with the reverse call.
        System.out.println("sb = "+sb);

        //12. indexOf
        System.out.println("indexOf jar in sb is = "+sb.indexOf("jar"));

        //13. indexOf with offset
        System.out.println("2ndIndexOf ee in sb is = "+sb.indexOf("ee", sb.indexOf("ee")+1));

        System.out.println("IndexOf Last without lastIndexOf method: ");
        StringBuilder sbrev=new StringBuilder(sb.toString());
        sbrev.reverse();
        //int revlastoccur = sbrev.indexOf("ee");
        int lastOccurIndex=sbrev.length() - sbrev.indexOf("ee") - "ee".length();
        System.out.println("lastOccurIndex = "+lastOccurIndex);

        //14. lastIndexOf
        System.out.println("lastIndexOf ee in sb = "+sb.lastIndexOf("ee"));

        //15. substring with start only
        System.out.println(sb.substring(5));
        //Q2) Did original sb itself change with substring method call?
        System.out.println(sb );
        //A2) No; the original sb value is intact even after substring call.

        //16. substring with both start and end
        System.out.println(sb.substring(5,7));
        //NOTE: StringBuilder's substring(...) method includes the start index and excludes the end index.
        System.out.println("sb = "+sb );
    }
}
