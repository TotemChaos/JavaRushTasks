package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        int start = 0;
        int end = 0;
        int count = 0;
        String result;

        try {
            for (int i = 0; i < string.length(); i++)
                if (string.charAt(i) == ' ')
                    count++;

            if (count == 4) {
                start = string.indexOf(" ");

                end = string.length();

            } else if (count > 4) {
                start = string.indexOf(" ");

                for (int i = 0; i < 5; i++)
                    end = string.indexOf(" ", end + 1);
            }

            result = string.substring(start + 1, end);

        } catch (Exception e) {
            throw new TooShortStringException(e);
        }

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(Exception e) {
            super.initCause(e);
        }
    }
}