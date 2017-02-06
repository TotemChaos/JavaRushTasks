package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public A clone() throws CloneNotSupportedException {
            A a = (A)super.clone();
            return a;
        }

        @Override
        public int hashCode() {
            final int prime = 37;
            int result = 1;
            result = prime * result + i + j;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(obj == this) return true;
            if(!(obj instanceof A)) return false;

            A a = new A(this.getI(), this.getJ());

            if(a.i != this.getI()) return false;
            return a.j == this.getJ();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException {
            C c = new C(this.getI(), this.getJ(), this.getName());
            return c;
        }
    }

    public static void main(String[] args) {
        A a = new A(1, 2);
        A aClone = null;
        B b = new B(3, 4, "B");
        B bClone = null;
        C c = new C(5, 6, "C");
        C cClone = null;

        try {
            aClone = a.clone();
            //bClone = b.clone();
            cClone = c.clone();

            System.out.println(a);
            System.out.println(aClone);

            System.out.println(b);
            //System.out.println(bClone);

            System.out.println(c);
            System.out.println(cClone);

            System.out.println((a.getI() == aClone.getI()) + " " + (a.getJ() == aClone.getJ()));
        } catch (CloneNotSupportedException e)  {
            e.printStackTrace(System.err);
        }
    }
}
