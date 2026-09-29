package com.javaProjectsBasic1.interviewSam;

import java.time.*;

public class ItemTimeNode {

    int value; //need to change to object later.
    LocalDateTime timeOfEntry;

    //getters, setters, toString

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getTimeOfEntry() {
        return timeOfEntry;
    }

    public void setTimeOfEntry(LocalDateTime timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }

}
