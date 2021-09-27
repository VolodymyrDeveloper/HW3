package com.cursor;

public class Circle {
    public double radius;

    public Circle(double enterRadius) {
        radius = enterRadius;
    }

    double calcCircleArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
