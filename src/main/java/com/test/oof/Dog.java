package com.test.oof;

public class Dog implements  Pet,Shape1 {
    public void test() {
        System.out.println("Interface Method Implemented");
    }
    public static void main(String args[]) {
        Pet p = new Dog();
        p.test();

        Shape1 shape1 = new Dog();
        shape1.test1();
    }

    @Override
    public void test1() {

        System.out.println("in test1 methiod");

    }
}
