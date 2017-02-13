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

            String[] words = sb.toString().split("\\s+");

            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        String lastSymbol = "";
        String[] tmpWords;

        if (words.length > 0 && !words[0].equals("")) {
            tmpWords = words;
            Arrays.sort(tmpWords);

            for (int m = 0; m < tmpWords.length; m++) {
                for (int n = 0; n < tmpWords.length; n++) {
                    if (tmpWords[m].equals(tmpWords[n]) && m != n)
                        tmpWords[n] = "";
                }
            }

            for (int i = 0; i < tmpWords.length; i++) {

                if (sb.length() == 0) {
                    sb.append(tmpWords[i]);
                    lastSymbol = String.valueOf(tmpWords[i].charAt(tmpWords[i].length() - 1)).toUpperCase();
                    tmpWords[i] = "";
                }

                for (int j = 0; j < tmpWords.length; j++) {

                    if (i != j && tmpWords[j].toUpperCase().startsWith(lastSymbol)) {
                        sb.append(" " + tmpWords[j]);
                        lastSymbol = String.valueOf(tmpWords[j].charAt(tmpWords[j].length() - 1)).toUpperCase();
                        tmpWords[j] = "";
                    }
                }
            }
        }

        return sb;
    }
}