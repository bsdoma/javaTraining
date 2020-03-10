package com.test;

public class PolyMorphism {

    public int add(int a,int b){
        System.out.println("addition of two numbers from integers");

        return a+b;
    }

    public float add(float a ,float b){
        System.out.println("addition of two numbers from floating points");
        return a+b;
    }

    public static void main(String[] args) {
        PolyMorphism polyMorphism = new PolyMorphism();
        System.out.println("addition of two numbers -->"+ polyMorphism.add(5,5));
        System.out.println("addition of two numbers -->"+ polyMorphism.add(5.0f,5.0f));
    }
}


