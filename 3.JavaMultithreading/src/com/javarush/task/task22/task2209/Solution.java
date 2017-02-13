package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader readFile = new BufferedReader(new FileReader("c:\\data.txt"))
        ) {
            StringBuilder sb = new StringBuilder();

            while (readFile.ready())
                sb.append(readFile.readLine() + " ");

            String[] str = sb.toString().split("\\s+");
            Arrays.sort(str);

            StringBuilder result = getLine(str);
            System.out.println(result.toString());
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        String lastSymbol = "";

        if (words.length > 0 && !words[0].equals("")) {
            for (int i = 0; i < words.length; i++) {

                if (sb.length() == 0) {
                    sb.append(words[i]);
                    lastSymbol = String.valueOf(words[i].charAt(words[i].length() - 1)).toUpperCase();
                    words[i] = "";
                }

                for (int j = 0; j < words.length; j++) {

                    if (i != j && words[j].toUpperCase().startsWith(lastSymbol)) {
                        sb.append(" " + words[j]);
                        lastSymbol = String.valueOf(words[j].charAt(words[j].length() - 1)).toUpperCase();
                        words[j] = "";
                    }
                }
            }
        }

        return sb;
    }
}