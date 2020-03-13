package com.test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Reflection_Demo {

    public static void main(String[] args) {
        // Creating object whose property is to be checked
        try {
            Test obj = new Test();

            Class cls = obj.getClass();
            System.out.println("The name of class is " +
                    cls.getName());

            Constructor constructor = cls.getConstructor();
            System.out.println("The name of constructor is " +
                    constructor.getName());

            System.out.println("The public methods of class are : ");

            Method[] methods = cls.getMethods();

            // Printing method names
            for (Method method : methods)
                System.out.println(method.getName());

            Method methodcall1 = cls.getDeclaredMethod("method2",
                    int.class);
            // invokes the method at runtime
            methodcall1.invoke(obj, 19);

            obj.method2(10);
            Field field = cls.getDeclaredField("s");
            field.setAccessible(true);
            field.set(obj, "JAVA");
            Method methodcall2 = cls.getDeclaredMethod("method1");

            // invokes the method at runtime
            methodcall2.invoke(obj);
            Method methodcall3 = cls.getDeclaredMethod("method3");
            //methodcall3.setAccessible(true);
            methodcall3.invoke(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
