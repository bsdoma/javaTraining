package com.test.serialize;

public class Serializable_Demo implements java.io.Serializable {
    public transient  int    a;
    public String b;

    // Default constructor
    public Serializable_Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }

}

