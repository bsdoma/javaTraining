package com.test.oof;

public class Rectangle extends Shape {
    public static void main(String args[]) {
        Rectangle obj = new Rectangle();
        obj.b = 200;
        obj.calculateArea(obj);
        obj.someMethod();
    }

    public void calculateArea(final Shape obj) {
        System.out.println("Area is " + (obj.b * obj.b));
    }
}
