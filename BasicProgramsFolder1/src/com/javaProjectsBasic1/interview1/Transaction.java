package com.javaProjectsBasic1.interview1;

import java.sql.Timestamp;

public class Transaction{

            private Integer acctNo;
            private Integer amount;
            private Timestamp date;
            private Integer seqNo;

    //Constructor
    public Transaction(Integer acctNo, Integer amount, Timestamp date, Integer seqNo) {
        this.acctNo=acctNo;
        this.amount=amount;
        this.date=date;
        this.seqNo=seqNo;
    }

}

