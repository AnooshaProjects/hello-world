package com.javaProjectsBasic1.jbdlClassTrialPkg1;

public class TryCatchFinallyTest1 {

    private int divide(int a, int b) {

        int c=0;
        try {
            c= a / b;
            //*So, ALWAYS CATCH and then PRINT/LOG any possible exceptions,
            // Because:
            // (1) to not swallow exceptions,
            // (2) to not lose the point/line where exception occurred,
            // (3) for the flow to return back to the main method, and
            // (4) to exit gracefully with exit code 0, even when there's error.
            // Note: If you re-throw the exception in catch back to the calling method,
            // then, you won't know which line of the try block actually caused the error.
            // So, be careful to not re-throw to caller if not necessary.
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
//            String s=null;
//            System.out.println("string s's length="+s.length());
        }
        return c;
    }

    public static void main(String[] args) {
        TryCatchFinallyTest1 obj1 = new TryCatchFinallyTest1();
        System.out.println("Before calling divide method");
        int a=20;
        int b=0;
        int c=obj1.divide(a,b);
        System.out.println("In main(), after divide method is done! c="+c);
    }

}
