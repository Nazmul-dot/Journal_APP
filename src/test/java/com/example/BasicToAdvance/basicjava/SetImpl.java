package com.example.BasicToAdvance.basicjava;

import java.util.HashSet;
import java.util.Set;

public class SetImpl {

    public static void setImpl(){
        Set<String> set = new HashSet<>(); // Most common, unordered
//        Set<String> treeSet = new TreeSet<>(); // Sorted
        set.add("Apple");
        set.add("Orange");
        set.add("Banana");
        set.add("Mango");

        set.add("Apple"); // Duplicates ignored
        set.add("Banana");


        boolean hasApple = set.contains("Apple");
        boolean hasMango = set.contains("Mango");

        int size = set.size(); // Number of elements
        boolean isEmpty = set.isEmpty(); // Check if set is empty

        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Iterate through elements
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Remove elements
        set.remove("Apple");
        set.remove("Mango");

        // Clear the set
        set.clear();
    }
}
