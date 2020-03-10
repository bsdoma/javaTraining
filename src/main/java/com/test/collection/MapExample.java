package com.test.collection;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("rama", "03-9516743");
        map.put("Sita", "09-5076452");
        map.put("Leo", "08-5530098");
        map.put("Rita", "06-8201124");
        System.out.println(map);
        //Iterating over key
        for (String key : map.keySet()) {
            System.out.println(key);
        }
         //Iterating over key-value pair
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
