package com.javaProjectsBasic1.jbdlClassTrialPkg1;

public class TryCatchFinallyTest1 {

    private int divide(int a, int b) {

        System.out.println("Entered divide(...) method!");
        int c = 0;
        try {
            System.out.println("Begin try block: c= "+c);
            System.out.println("Next step is division of a/b:");
            c = a / b;
            System.out.println("a and b values in try block are");
            System.out.print(a+" "+b);
            System.out.println("c value after division, in try block, is "+c);
            System.out.println("------last line in try block----------");
            //*So, ALWAYS CATCH and then PRINT/LOG any possible exceptions,
            // Because:
            // (1) to not swallow exceptions,
            // (2) to not lose the point/line where exception occurred,
            // (3) for the flow to return back to the main method, and
            // (4) to exit gracefully with exit code 0, even when there's error.
            // NOTE (1):
            // (i) If you have catch block and log/print the error there itself,
            // then, the control will return back to the next line of the caller, execute from there,
            // and then, exit 0 gracefully.
            // (ii) Check for exact error details in the .err file AND the log file!!!!
            // NOTE (2): If you re-throw the exception in catch back to the calling method,
            // then, you won't know which line of the try block actually caused the error.
            // So, be careful to not re-throw to caller if not necessary.
            // NOTE (3): If you re-throw the exception to the caller, from catch block of callee,
            // then control won't return to next line of caller, and
            // also, won't exit gracefully. It will return exit code 1.
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
/*
            String s=null;
            System.out.println("string s's length="+s.length());
*/
        }
        finally{
            System.out.println("finally block is always used with try-catch to run inspite of anything!");
            System.out.println("finally block is generally used to close ResultSet, DB Connection, etc");
        }
        return c;
    }

    public static void main(String[] args) {
        TryCatchFinallyTest1 obj1 = new TryCatchFinallyTest1();
        System.out.println("In main(...), before calling divide(...) method!");
        int a=20;
        int b=0;
        int c=obj1.divide(a,b);
        System.out.println("In main(...), AFTER divide(...) method is done!! c="+c);
        System.out.println("Last line in main(...)");
    }

}
