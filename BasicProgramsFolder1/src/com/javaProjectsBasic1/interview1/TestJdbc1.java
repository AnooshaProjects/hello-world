package com.javaProjectsBasic1.interview1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc1 {

    public static void main(String[] args) {

        //take the input from String[] args
        //validation - not null, actNum in certain range, should not be 0 or greater than a maxnum
        Timestamp strtDt=null;
        Timestamp endDt=null;
        TestJdbc1 tj1=new TestJdbc1();

        try {
            tj1.executeSql(1, strtDt, endDt, 1, 1000);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            //add robust logging
            throw new RuntimeException(e);
        }

    }

    public void executeSql(int actNum, Timestamp startDate, Timestamp endDate, int strow, int endRow)
            throws SQLException, ClassNotFoundException {
        //select count(1)
        String sql="select * from (SELECT ACCOUNT_NO, AMOUNT, DATE, SEQ_NO, rownum FROM TRANSACTION\n" +
                "WHERE ACCOUNT_NO = ? AND DATE > ? AND DATE < ?) " +
                "where rownum>=1 and rownum<=1000";

//step1 load the driver class
        Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
        Connection conn=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

        //Connection conn; //initialize with driver, db type
        ResultSet rs;

        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1, actNum);
        pstmt.setTimestamp(2,startDate);
        pstmt.setTimestamp(3, endDate);

        rs=pstmt.executeQuery();

        System.out.println("ACCOUNT_NO\tAMOUNT\tDATE\tSEQ_NO");
        List<Transaction> txnlist = new ArrayList<>();
        while(rs.next()){
            Transaction txn=new Transaction(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getTimestamp(3),
                    rs.getInt(4)
            );
            txnlist.add(txn);

            System.out.println(rs.getInt(1)+"\t"+
                    rs.getInt(2)+"\t"+
                    rs.getTimestamp(3)+"\t"+
                    rs.getInt(4));
        }

        //Add explicit try-catch-finally blocks and close resultsets & connection in finally block
        conn.close();

    }
}
