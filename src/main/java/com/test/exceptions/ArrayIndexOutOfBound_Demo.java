package com.test.exceptions;

public class ArrayIndexOutOfBound_Demo {
    public static void main(String args[])
    {
        try{
            int a[] = new int[5];
            a[4] = 9; // accessing 7th element in an array of
            // size 5
        }catch( ArithmeticException  | ArrayIndexOutOfBoundsException e){
            System.out.println ("Array Index is Out Of Bounds");
        }catch(Exception e){
            System.out.println ("Array Index is Out Of from Exception");
        }

    }

}
