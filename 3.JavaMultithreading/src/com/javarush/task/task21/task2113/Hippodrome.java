package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public static Hippodrome game;

    public List<Horse> getHorses()  {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move()  {
        for(Horse horse : horses)
            horse.move();
    }

    public void print() {
        for(Horse horse : horses)
            horse.print();

        for(int i = 0; i < 10; i++)
            System.out.println();
    }

    public void run() throws InterruptedException {
        for(int i = 1; i < 101; i++)    {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) throws InterruptedException   {
        List<Horse> h = new ArrayList<>();
        h.add(new Horse("horse1", 3, 0));
        h.add(new Horse("horse2", 3, 0));
        h.add(new Horse("horse3", 3, 0));

        game = new Hippodrome(h);

        game.run();
    }
}
