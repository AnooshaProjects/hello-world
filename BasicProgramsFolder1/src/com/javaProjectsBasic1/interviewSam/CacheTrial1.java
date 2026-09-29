package com.javaProjectsBasic1.interviewSam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CacheTrial1 {
    List<ItemTimeNode> list;
    int maxCapacity;

    public CacheTrial1(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    //LRU Cache = Least Recently Used cache

    //1. Creates cache when called with data
    public void insertNewCacheObj(int userVal){
        if(list==null || list.isEmpty()){
            list = new ArrayList<>();
        }
        ItemTimeNode in1=new ItemTimeNode();
        in1.setValue(userVal);
        in1.setTimeOfEntry(LocalDateTime.now());

        list.add(in1);
    }

    public ItemTimeNode deleteOldestCacheObj(){

        if(list==null || list.isEmpty()){
            return null;
        }

        Optional<ItemTimeNode> first = list.stream().sorted(Comparator.comparing(el -> el.getTimeOfEntry()))
                .findFirst();

        if (first.isPresent()){
            list.remove(first.get());
            return first.get();
        }

        return null;
    }

    public void lruUpdateTrial(int newUserVal1){
        if (list.size()==maxCapacity){
            deleteOldestCacheObj();
            insertNewCacheObj(newUserVal1);
        } else {
            insertNewCacheObj(newUserVal1);
        }
    }

}
