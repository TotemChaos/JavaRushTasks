package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("0", 500);
        for(int i = 1; i < 10; i++)
            result.put(i + "", 499);
        return result;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) itr.next();
            if ((Integer)pair.getValue() < 500)
                itr.remove();
        }
    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());
    }
}