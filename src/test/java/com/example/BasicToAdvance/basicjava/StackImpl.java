package com.example.BasicToAdvance.basicjava;

import java.util.Stack;

public class StackImpl {

    public static void stackImpl() {
        Stack<String> stack = new Stack<>();

        // Push elements
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Orange");

// Pop elements
        String top = stack.pop(); // Removes and returns "Orange"

// Peek at top
        String currentTop = stack.peek(); // Returns "Banana" without removing

// Check if empty
        boolean isEmpty = stack.isEmpty();

// Get size
        int size = stack.size();
    }
}
