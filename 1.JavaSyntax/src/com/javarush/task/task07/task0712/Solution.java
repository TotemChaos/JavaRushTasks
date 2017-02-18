package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String read;
            ArrayList<String> list = new ArrayList<>();
            int count = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, indexMax = 0, indexMin = 0;

            while (!(read = reader.readLine()).isEmpty()) {
                list.add(read);
                count++;
                if(count == 10)
                    break;
            }

            for(int i = 0; i < list.size(); i++)    {
                if(list.get(i).length() < min)    {
                    min = list.get(i).length();
                    indexMin = i;
                }
                if(list.get(i).length() > max) {
                    max = list.get(i).length();
                    indexMax = i;
                }
            }

            System.out.println(indexMin < indexMax ? list.get(indexMin) : list.get(indexMax));
        }
    }
}
