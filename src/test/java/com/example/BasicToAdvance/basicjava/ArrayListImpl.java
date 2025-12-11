package com.example.BasicToAdvance.basicjava;

import java.util.*;

public class ArrayListImpl {

    public static void arrayListImpl(){
        // Create empty ArrayList
        ArrayList<String> list = new ArrayList<>();

// Create with initial capacity
        ArrayList<Integer> numbers = new ArrayList<>(20);

// Initialize with values (Java 9+)
        ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange"));

// Initialize from another collection
        List<String> anotherList = Arrays.asList("Red", "Green", "Blue");
        ArrayList<String> colors = new ArrayList<>(anotherList);

        // Add single element
        fruits.add("Mango");

// Add at specific index
        fruits.add(1, "Grape"); // Inserts at position 1

// Add multiple elements
        fruits.addAll(Arrays.asList("Peach", "Pear"));

// Add multiple from another collection
        fruits.addAll(colors); // Adds all elements from colors list

        // Get by index
        String first = fruits.get(0);

// Get first element
//        String firstElement = fruits.getFirst(); // Java 21+

// Get last element
//        String lastElement = fruits.getLast(); // Java 21+

// Check if empty
        boolean empty = fruits.isEmpty();

// Get size
        int size = fruits.size();

// Check if contains element
        boolean hasApple = fruits.contains("Apple");

// Find index of element
        int index = fruits.indexOf("Banana"); // Returns -1 if not found

// Find last index of element
        int lastIndex = fruits.lastIndexOf("Apple"); // For duplicate elements

        // Set element at index (replace)
        fruits.set(0, "Pineapple");


        // Remove by index
        String removed = fruits.remove(0);

// Remove by value
        boolean wasRemoved = fruits.remove("Banana");

// Remove all elements matching condition (Java 8+)
        fruits.removeIf(fruit -> fruit.startsWith("A"));

// Remove all elements from another collection
        fruits.removeAll(colors);

        // Clear all elements
        fruits.clear();

        // For loop
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

// Enhanced for loop
        for (String fruit : fruits) {
            System.out.println(fruit);
        }


        // Natural order sort
        Collections.sort(fruits);

// Sort with comparator
        fruits.sort(Comparator.comparing(String::length));

// Reverse order
        fruits.sort(Comparator.reverseOrder());

        // Convert to array
        String[] array = fruits.toArray(new String[0]);

        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        int[] arr = list1.stream().mapToInt(i -> i).toArray();

        // convert to arraylist
        List<Integer> list2=new ArrayList<>();
        for (int num : arr) {
            list2.add(num);
        }


    }
}
