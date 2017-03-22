package com.javarush.task.task23.task2312;

import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive()    {
        return isAlive;
    }

    public void setDirection(SnakeDirection direction)  {
        this.direction = direction;
    }

    public SnakeDirection getDirection()    {
        return direction;
    }

    public void move()  {
        if(!isAlive) return;

        if(direction == SnakeDirection.UP)
            move(0, -1);
        else if(direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if(direction == SnakeDirection.DOWN)
            move(0, 1);
        else if(direction == SnakeDirection.LEFT)
            move(-1, 0);
    }

    public void move(int x, int y)  {}

    public int getX()   {
        return sections.get(0).getX();
    }

    public int getY()   {
        return sections.get(0).getY();
    }

    public Snake(int x, int y)  {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public void checkBorders(SnakeSection head) {
        if(head.getX() >= Room.game.getWidth() || head.getX() < 0
                || head.getY() >= Room.game.getHeight()|| head.getY() < 0)
            isAlive = false;
    }

    public void checkBody(SnakeSection head) {
        if(sections.contains(head))
            isAlive = false;
    }
}
