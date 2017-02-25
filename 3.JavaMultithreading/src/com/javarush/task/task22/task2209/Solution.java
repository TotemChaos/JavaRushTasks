package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //Long t0 = System.currentTimeMillis();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader readFile = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            StringBuilder sb = new StringBuilder();

            while (readFile.ready())
                sb.append(readFile.readLine() + " ");

            String[] words = sb.toString().split("\\s");

            StringBuilder result = getLine(words);
            System.out.println(result.toString().trim());
        }
        //Long t1 = System.currentTimeMillis();
        //System.out.println("Time: " + (t1 - t0) / 1000d + " sec");
        //System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        List<String> strArr = new ArrayList<>(Arrays.asList(words));

        if (words.length == 0) return new StringBuilder();

        sb.append(strArr.get(0));
        strArr.remove(0);

        while (strArr.size() > 0)   {
            for (int i = 0; i < strArr.size(); i++) {
                String a = strArr.get(i).toLowerCase();
                String b = sb.toString().toLowerCase();

                if (a.charAt(0) == b.charAt(sb.length() - 1))   {
                    sb.append(" " + strArr.get(i));
                    strArr.remove(i);
                    continue;
                }

                if (b.charAt(0) == a.charAt(a.length() - 1))    {
                    sb.insert(0, strArr.get(i) + " ");
                    strArr.remove(i);
                }
            }
        }

        return sb;
    }
}