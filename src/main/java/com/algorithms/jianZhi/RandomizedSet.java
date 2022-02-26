package com.algorithms.jianZhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/*
JianZhi Offer 2-030
Leeetcode 0380
 */
public class RandomizedSet {
    private HashMap<Integer,Integer> hashMap;
    private ArrayList<Integer> list;
    private int size;

    public RandomizedSet() {
        this.hashMap = new HashMap<>();
        this.list = new ArrayList<>();
        this.size = 0;
    }

    public boolean insert(int val) {
        if(hashMap.containsKey(val)){
            return false;
        }else{
            list.add(val);
            hashMap.put(val,size);
            size++;
            return true;
        }
    }

    public boolean remove(int val) {
        if(hashMap.containsKey(val)){
            Integer temp = list.get(size-1);
            Integer position = hashMap.get(val);
            list.set(position,temp);
            list.remove(--size);
            hashMap.put(temp,position);
            hashMap.remove(val);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        int randomPosition = ThreadLocalRandom.current().nextInt(0,size);
        return list.get(randomPosition);
    }
}
