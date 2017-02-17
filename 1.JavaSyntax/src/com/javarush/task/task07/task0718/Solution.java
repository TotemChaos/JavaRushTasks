package com.javarush.task.task07.task0718;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextLine());
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() <= list.get(i + 1).length()) {
            } else {
                System.out.println(i + 1);
                break;
            }
        }
    }
}

