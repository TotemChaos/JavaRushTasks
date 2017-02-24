package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    private double x, y, radius;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean isIntersec(BaseObject o)    {
        double xDistance = this.x - o.x;
        double yDistance = this.y - o.y;
        double distance = Math.sqrt((xDistance*xDistance)+(yDistance*yDistance));
        return distance < Math.max(this.radius, o.radius);
    }

    public abstract void move();

    public abstract void draw(Canvas canvas);
}
