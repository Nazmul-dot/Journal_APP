package com.example.BasicToAdvance.basicjava;

import java.util.*;

public class MapMenipulation {

    public static void mapManipulation(){
        Map<String, Integer> map = new HashMap<>(); // Most common
        Map<String, Integer> anotherMap = new HashMap<>();
//        Map<String, Integer> treeMap = new TreeMap<>();

        map.put("Apple",10);
        map.put("Orange",20);
        map.put("Banana",30);
        map.put("Mango",40);
//      Map<String,Integer> mp=  Map.of("abc",1);

        map.put("Apple", 15); // Update existing value
        map.putIfAbsent("Banana", 20); // Only put if key doesn't exist
        map.putAll(anotherMap); // Add all entries from another map

        int apples = map.get("Apple"); // Get value by key
        int oranges = map.getOrDefault("Orange", 0); // Default if key missing

        boolean hasApple = map.containsKey("Apple"); // Check if key exists
        boolean hasQty20 = map.containsValue(20); // Check if value exists

        Set<String> keys = map.keySet(); // Get all keys
        Collection<Integer> values = map.values(); // Get all values

        map.remove("Apple"); // Remove by key
        map.remove("Banana", 5); // Remove only if key-value matches
        map.clear(); // Remove all entries


        // Iterate through entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        int size = map.size(); // Number of entries
        boolean isEmpty = map.isEmpty(); // Check if map is empty

        int [] arr={1,2,3,4,5,6,7,8,9,10};
        Map<Integer,Integer> map1=new HashMap<>();

        for(int key : arr){
            if(map1.containsKey(key)){
                map1.put(key,map1.get(key)+1);
            }else{
                map1.put(key,1);
            }
        }


    }

    public static void main(String[] args) {
        //mapManipulation();
        MapMenipulation.mapManipulation();
    }
}
