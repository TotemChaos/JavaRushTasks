package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static Map<String, String> params = new LinkedHashMap<>();

    public static void main(String[] args) {
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);

        System.out.println(getQuery(params));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry entry : params.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                if (sb.length() == 0)
                    sb.append(String.format("%s = '%s'", entry.getKey(), entry.getValue()));
                else sb.append(String.format(" and %s = '%s'", entry.getKey(), entry.getValue()));
            }
        }

        return sb.toString();
    }
}
