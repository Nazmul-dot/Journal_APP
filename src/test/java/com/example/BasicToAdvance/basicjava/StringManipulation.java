package com.example.BasicToAdvance.basicjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.*;

public class StringManipulation {

    void stringManipulation() {
        String str="Hello World how are you mane whats up   ";
        System.out.println();
        System.out.println("convert string to char");
        char[] ch=str.toCharArray();
        for (char c : ch) {
            System.out.print(c + " ");
        }


        char lower = 'a';
        char upper = 'A';

        // Convert to uppercase
        char toUpper = Character.toUpperCase(lower);
        System.out.println("Convert to uppercase");
        System.out.println(lower + " → " + toUpper); // a → A

        // Convert to lowercase
        char toLower = Character.toLowerCase(upper);
        System.out.println("Convert to lowercase");
        System.out.println(upper + " → " + toLower);

        System.out.println("convert lower case all = ");
        String lowerCase=str.toLowerCase();
        System.out.println(lowerCase);

        System.out.println("convert upper case all = ");
        String upperCase=str.toUpperCase();
        System.out.println(upperCase);


        String input = "springboot";
        char[] chars = input.toCharArray(); // Convert to char array
        Arrays.sort(chars);                // Sort the array
        String sorted = new String(chars); // Convert back to string
        System.out.println("Sorted: " + sorted);


        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string = " + reversed);

        System.out.println("replace string = ");
        String replace=str.replace("mane","man");
        System.out.println(replace);

        System.out.println("replace all string = ");
        String replaceAll=str.replaceAll("mane","man");
        System.out.println(replaceAll);

        System.out.println("contains string = ");
        boolean contains=str.contains("mane");
        System.out.println(contains);

        System.out.println("starts with string = ");
        boolean startsWith=str.startsWith("Hello");
        System.out.println(startsWith);

        System.out.println("ends with string = ");
        boolean endsWith=str.endsWith("mane");
        System.out.println(endsWith);

        System.out.println("substring string = ");
        String substring=str.substring(1,7);
        System.out.println(substring);

        System.out.println("index of string = ");
        int indexOf=str.indexOf("mane");
        System.out.println(indexOf);

        System.out.println("last index of string = ");
        int lastIndexOf=str.lastIndexOf("mane");
        System.out.println(lastIndexOf);

        System.out.println("split string = ");
        String[] split=str.split(" ");
        int cnt=0;
        for (String s : split) {
            cnt++;
            String rev=new StringBuilder(s).reverse().toString();
            System.out.print(rev + " ");
        }
        System.out.println(cnt);

        System.out.println("join string = ");
        String join=String.join(" ",split);
        System.out.println(join);



        System.out.println("\nOriginal string: '" + str + "'");
        System.out.println("Length: " + str.length());
        System.out.println("Is empty: " + str.isEmpty());
        System.out.println("Is blank: " + str.isBlank()); // Java 11+
        System.out.println("Trimmed length: " + str.trim().length());

        // 2. Case Conversion
        System.out.println("\nLower case: " + str.toLowerCase());
        System.out.println("Upper case: " + str.toUpperCase());
        System.out.println("Capitalized: " + capitalizeWords(str));


        // 4. String Reversal
        System.out.println("\n\nReversed:");
        System.out.println("Full reverse: " + new StringBuilder(str).reverse());
        System.out.println("Words reversed: " + reverseWords(str)); // Custom method



        // 5. Search Operations
        System.out.println("\nSearch Operations:");
        System.out.println("Contains 'mane': " + str.contains("mane"));
        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("Ends with 'up': " + str.endsWith("up"));
        System.out.println("First 'o' at: " + str.indexOf('o'));
        System.out.println("Last 'o' at: " + str.lastIndexOf('o'));
        System.out.println("First 'are' at: " + str.indexOf("are"));
        System.out.println("'mane' at: " + str.indexOf("mane"));



        // 6. Substring Operations
        System.out.println("\nSubstring Operations:");
        System.out.println("Substring(6,11): '" + str.substring(6, 11) + "'");
        System.out.println("From index 13: '" + str.substring(13) + "'");
        System.out.println("from index 2: "+ str.substring(2));


        // 7. Replacement Operations
        System.out.println("\nReplacement Operations:");
        System.out.println("Replace 'mane' with 'man': " + str.replace("mane", "man"));
        System.out.println("Replace all spaces with underscore: " + str.replaceAll(" ", "_"));
        System.out.println("Replace first space: " + str.replaceFirst(" ", "_"));
        System.out.println("Remove all spaces: " + str.replace(" ", ""));


        // 8. Splitting and Joining
        System.out.println("\nSplitting and Joining:");
        String[] words = str.trim().split("\\s+");
        System.out.println("Word count: " + words.length);
        System.out.println("Joined with commas: " + String.join(", ", words));
        System.out.println("Joined with pipes: " + String.join("|", words));


        // 9. Comparison Operations
        System.out.println("\nComparison Operations:");
        System.out.println("Equals 'Hello': " + str.equals("Hello"));
        System.out.println("Equals ignore case: " + str.equalsIgnoreCase("hello world how are you mane whats up"));


        System.out.println("string to number = ");
        int num=Integer.parseInt("123");
        System.out.println(num);
        System.out.println("string to double = ");
        double num1=Double.parseDouble("123.456");
        System.out.println(num1);
        System.out.println("string to float = ");
        float num2=Float.parseFloat("123.456");
        System.out.println(num2);

        System.out.println("number to string = ");
        String num3=Integer.toString(123);
        System.out.println(num3);

        System.out.println("double to string = ");
        String num4=Double.toString(123.456);
        System.out.println(num4);

        System.out.println("float to string = ");
        String num5=Float.toString(123.456f);
        System.out.println(num5);


    }

    // Helper method to capitalize each word
    private String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return Arrays.stream(input.split("\\s+"))
                .map(word -> word.isEmpty()
                        ? word
                        : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    // Helper method to reverse word order
    private String reverseWords(String input) {
        String[] words = input.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static String reverseStr1(String str){
//            StringBuilder sb = new StringBuilder(str);
//            sb.reverse();
//            return sb.toString();
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(" ");
        for(String  word : split){
            String hold=new StringBuilder(word).reverse().toString();
            sb.append(hold);
            sb.append(" ");
        }

        String reversed=sb.toString().trim();
        return reversed;
    }

    public static String reverseStr2(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }

        return Arrays.stream(str.trim().split("\\s+"))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        StringManipulation sm=new StringManipulation();
        sm.stringManipulation();
    }

}
