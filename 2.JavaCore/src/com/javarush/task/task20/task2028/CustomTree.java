package com.javarush.task.task20.task2028;

import java.io.*;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree
        extends AbstractList<String>
        implements List<String>, Cloneable, Serializable    {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        List<String> listTree = new CustomTree();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);

        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new CustomTree();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new CustomTree();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("\nExpected 3, actual is " + ((CustomTree) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) listTree).getParent("11"));
        listTree.clear();
        for (int i = 1; i < 16; i++) {
            listTree.add(String.valueOf(i));
        }

        //For additional check correct work clone method
        CustomTree list = ((CustomTree)listTree).clone();

        System.out.println("Start value with using clone: " + listTree);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n===== ADD 21 and 22 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        //list.add(null);
        for (String s : list) System.out.print(s+ " ");
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((CustomTree) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((CustomTree) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((CustomTree) list).getParent(null));
        System.out.println("15 Expected 7, actual is " + ((CustomTree) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((CustomTree) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((CustomTree) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((CustomTree) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((CustomTree) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((CustomTree) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((CustomTree) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((CustomTree) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((CustomTree) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((CustomTree) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((CustomTree) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((CustomTree) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((CustomTree) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((CustomTree) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((CustomTree) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((CustomTree) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((CustomTree) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

        System.out.println("=============== Clone test ==================");

        System.out.println("Object: " + list + " --> Size = " + list.size());
        CustomTree sol = list.clone();
        //list.remove("7"); //Select for test
        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
        System.out.println("Result: " + list.containsAll(sol));

        System.out.println("\nTest addAll: ");
        CustomTree add = new CustomTree();
        add.addAll(sol);
        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());

        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            if (itr2.next().contains("31")) {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list);
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2);

        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree);
        listTree.clear();
        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));
    }

    public String getParent(String value) {
        for(Node<String> node = first;  node != null; node = node.next) {
            if(node.item.equals(value))
                if(node.parent == null)
                    return null;
                else return node.parent.item;
        }
        return null;
    }

    private int size = 0;
    private Node<String> first;
    private Node<String> last;
    private Node<String> root = new Node<>(null, null, null);

    public CustomTree() {}

    private static class Node<String> implements Serializable {
        String item;
        Node<String> next;
        Node<String> prev;
        Node<String> parent;
        Node<String> leftChild;
        Node<String> rightChild;

        Node(Node<String> prev, String element, Node<String> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException("Access from index denied");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(String s) {
        final Node<String> l = last;
        final Node<String> newNode = new Node<>(l, s, null);
        last = newNode;
        if (l == null) {
            first = newNode;
            root = newNode;
        }else if(l == first) {
            l.next = newNode;
        } else  {
            l.next = newNode;
            if (root.rightChild != null)
                root = root.next;

            newNode.parent = root;

            if (root.leftChild == null)
                root.leftChild = newNode;
            else
                root.rightChild = newNode;
        }

        size++;
        return true;
    }

    String unlink(Node<String> x) {
        final String element = x.item;
        final Node<String> next = x.next;
        final Node<String> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        if(x.parent != null)    {
            if(x.parent.leftChild == x)
                x.parent.leftChild = null;
            else if(x.parent.rightChild == x)
                x.parent.rightChild = null;
        }

        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<String> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                }
            }
        } else {
            for (Node<String> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    if(x.leftChild != null)
                        remove(x.leftChild.item);
                    if(x.rightChild != null)
                        remove(x.rightChild.item);
                    unlink(x);
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (Node<String> x = first; x != null; ) {
            Node<String> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {

        private int nextIndex = 0;
        private Node<String> lastReturned;
        private Node<String> next = first;

        private Itr() { }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<String> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
        }
    }

    @Override
    protected CustomTree clone() throws CloneNotSupportedException {
        CustomTree clone = new CustomTree();
        for (Node<String> x = first; x != null; x = x.next) {
            clone.add(x.item);
        }
        return clone;
    }
}