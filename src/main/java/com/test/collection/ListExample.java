package com.test.collection;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("hello");
        list.add("hello");
        list.add("world");
        System.out.println("list size-->"+ list.size());
        for(String s:list){
            System.out.println(s);
        }

        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        list.stream().forEach(str->System.out.println(str));

        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Hello");
        System.out.println("set size-->"+ set.size());

    }
}
