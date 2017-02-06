package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.users == clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() throws CloneNotSupportedException {
            User user = (User)super.clone();
            return user;
        }
    }

    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();

        solution.users = new LinkedHashMap<>(this.users);

        return solution;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;

        result = prime * result + users.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Solution))  return false;

        Solution sol = (Solution)obj;

        return users != null ? users.equals(sol.users) : sol.users == null;
    }
}