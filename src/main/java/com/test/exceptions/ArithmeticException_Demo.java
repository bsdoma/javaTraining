package com.test.exceptions;

public class ArithmeticException_Demo {
    public static void main(String args[])
    {
        try {
            int a = 30, b = 0;
            int c = a / b;  // cannot divide by zero
            System.out.println("Result = " + c);
        }catch(Exception e){
            System.out.println("Arthimatic Exception");
        }

    }

}
