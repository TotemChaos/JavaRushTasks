package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String result;
        int count = 0;
        int start = 0;
        int end = 0;

        try {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '\t') {
                    count++;

                    if (count == 1)
                        start = i;
                    else if (count == 2)
                        end = i;
                }
            }

            if (count > 1)
                result = string.substring(start + 1, end);
            else throw new TooShortStringException();

        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
