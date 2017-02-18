package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            int[] numbers = new int[15];
            int even = 0, odd = 0;

            for(int i = 0; i < numbers.length; i++)  {
                numbers[i] = Integer.parseInt(reader.readLine());
                if(i == 0 || i % 2 == 0)
                    even += numbers[i];
                else odd += numbers[i];
            }

            System.out.println(even < odd ? "В домах с нечетными номерами проживает больше жителей." : "В домах с четными номерами проживает больше жителей.");
        }
    }
}
