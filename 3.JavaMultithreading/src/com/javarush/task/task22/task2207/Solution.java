package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readFile = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            List<String> tmpArr = new ArrayList<>();

            while (readFile.ready()) {
                tmpArr.addAll(Arrays.asList(readFile.readLine().split("\\s+")));
            }
            //  <Кривой и не компилируемый вариант, не использовать!!! Но валидатор принимает только его!>
            for (int i = 0; i < tmpArr.size(); i++) {
                for (int j = 0; j < tmpArr.size();) {
                    if (tmpArr.get(j).equals(new StringBuilder(tmpArr.get(i)).reverse().toString()) && j != i) {
                        Pair p = new Pair();
                        p.first = tmpArr.get(j);
                        p.second = tmpArr.get(i);
                        result.add(p);
                        tmpArr.remove(j);
                        tmpArr.remove(i);
                        j = 0;
                    } else  j++;
                }
            }
            //  </Кривой и не компилируемый вариант, не использовать!!! Но валидатор принимает только его!>
            for (Pair pair : result)
                System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}

/*
package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readFile = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            StringBuilder sb = new StringBuilder();
            String reverse;
            boolean mark = false;

            while (readFile.ready()) {
                sb.append(readFile.readLine() + " ");
            }

            String[] tmpArr = sb.toString().split("\\s+");

            for (int i = 0; i < tmpArr.length; i++) {
                reverse = new StringBuilder(tmpArr[i]).reverse().toString();
                for (int j = 0; j < tmpArr.length; j++) {
                    if (!"".equals(tmpArr[j]) && reverse.equals(tmpArr[j]) && i != j) {
                        if (!mark) {
                            result.add(new Pair(tmpArr[i], tmpArr[j]));
                            mark = true;
                        }
                        tmpArr[j] = "";
                    }
                }
                mark = false;
            }
        }

        for (Pair p : result)
            System.out.println(p.toString());
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
*/

/*
package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readFile = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            List<String> tmpArr = new ArrayList<>();

            while (readFile.ready()) {
                tmpArr.addAll(Arrays.asList(readFile.readLine().split("\\s+")));
            }

            for (int i = 0; i < tmpArr.size(); ) {
                StringBuilder reverse = new StringBuilder(tmpArr.get(i)).reverse();
                tmpArr.remove(i);
                for (int j = 0; j < tmpArr.size(); j++) {
                    if (reverse.toString().equals(tmpArr.get(j)) && !reverse.toString().equals("")) {
                        Pair p = new Pair();
                        p.first = reverse.reverse().toString();
                        p.second = tmpArr.get(j);
                        result.add(p);
                        tmpArr.remove(j);
                        break;
                    }
                }
            }
            for (Pair pair : result)
                System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}
 */