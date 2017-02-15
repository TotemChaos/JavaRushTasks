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
        Long t0 = System.currentTimeMillis();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader readFile = new BufferedReader(new FileReader("c:\\data.txt"))
        ) {
            StringBuilder sb = new StringBuilder();

            while (readFile.ready())
                    sb.append(readFile.readLine() + " ");

            String[] words = sb.toString().split("\\s+");

            StringBuilder result = getLine(words);
            System.out.println(result.toString().trim());
        }
        Long t1 = System.currentTimeMillis();
        System.out.println("Time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        List<String> strArr = new ArrayList<>(Arrays.asList(words));

        if (strArr == null || strArr.size() == 0) return sb;
        else if (strArr.size() == 1) return sb.append(words[0]);

        int count = 0;
        Map<String, String> strSet = new HashMap<>();

        for(String s : strArr)
            strSet.put(s, String.valueOf(s.charAt(0)).toLowerCase());

        while (count != strArr.size() - 1) {
            Collections.shuffle(strArr);
            count = 0;

            for (int i = 0; i < strArr.size() - 1; i++) {
                if (strArr.get(i).endsWith(strSet.get(strArr.get(i + 1)))) {
                    count++;
                } else break;
            }
        }

        for (String s : strArr)
            sb.append(s + " ");

        return sb;
    }
}