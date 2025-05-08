package com.example.BasicToAdvance.basicjava;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {

    public static void queueImpl(){
        Queue<String> queue = new LinkedList<>();
        queue.add("Apple");
        queue.add("Orange");
        queue.add("Banana");
        queue.add("Mango");

        String head = queue.remove(); // Remove and return head (throws if empty)
        String headOrNull = queue.poll(); // Remove and return head (returns null if empty)

        String head2 = queue.element(); // View head without removal (throws if empty)
        String headOrNull2 = queue.peek(); // View head without removal (returns null if empty)

        int size = queue.size(); // Get number of elements
        boolean isEmpty = queue.isEmpty(); // Check if queue is empty
        boolean contains = queue.contains("Apple"); // Check if element exists

        boolean hasApple = queue.contains("Apple");
        boolean hasMango = queue.contains("Mango");


        for (String fruit : queue) {
            System.out.println(fruit);
        }

        // Iterate through elements
        for (String fruit : queue) {
            System.out.println(fruit);
        }

        System.out.println("peek = " + queue.peek());
        System.out.println("poll = " + queue.poll());


        // Remove elements
        queue.remove();
        queue.remove();

        // Clear the queue
        queue.clear();

    }
}
