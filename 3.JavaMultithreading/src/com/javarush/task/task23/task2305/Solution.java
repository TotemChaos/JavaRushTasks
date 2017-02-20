package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();

        solution1.innerClasses = new InnerClass[2]{new Solution().new InnerClass(), new Solution().new InnerClass()};
        solution2.innerClasses = new InnerClass[2];

        Solution[] sol = new Solution[]{solution1, solution2};

        return sol;
    }

    public static void main(String[] args) {

    }
}
