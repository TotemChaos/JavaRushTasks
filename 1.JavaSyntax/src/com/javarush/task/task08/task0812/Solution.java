package com.javarush.task.task08.task0812;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int max = 1;
        int count = 1;

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextInt());
        }

        for(int i = 0; i < list.size() - 1; i++)    {
            if(list.get(i) == list.get(i + 1))
                count++;
            else count = 1;

            if(count > max)
                max = count;
        }

        System.out.println(max);
    }
}