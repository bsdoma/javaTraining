package com.test;

public class Men extends Person{

    public static void main(String[] args) {
        Person man = new Men();
        man.eating();


        Person man1 = new Person();
        man1.eating();



    }

    public Men(){}

    public Men(int age,String name){
        super(age,name);
    }

    public void eating(){
        System.out.println("in Men Class eating");
    }

}
