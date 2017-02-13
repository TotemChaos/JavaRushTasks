package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            String[] words = new String[]{};

            while (readFile.ready())
                words = readFile.readLine().split("\\s+");

            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }
        Long t1 = System.currentTimeMillis();
        System.out.println("Time: " + (t1 - t0)/ 1000d + " sec");
        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String lastSymbol = "";

        if (words != null && words.length == 1) {
            sb.append(words[0]);

        } else if (words != null && words.length > 0) {
            List<String> strArr = new ArrayList<>(Arrays.asList(words));

            while (count != strArr.size()) {
                count = 0;
                sb = new StringBuilder();
                sb.append(strArr.get(0));

                for (int i = 1; i < strArr.size(); i++) {
                    lastSymbol = String.valueOf(strArr.get(i - 1).charAt(strArr.get(i - 1).length() - 1)).toUpperCase();

                    if (strArr.get(i).startsWith(lastSymbol)) {
                        sb.append(" " + strArr.get(i));
                        count++;
                    } else break;
                    System.out.println(strArr.size() + " " + count);
                }
                Collections.shuffle(strArr);
            }
        }
        return sb;
    }
}