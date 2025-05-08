//package com.example.BasicToAdvance.basicjava;
//
//import java.util.*;
//
//public class InputOutputTest {
//
//    public static void inputOutput() {
//
//        Scanner in = new Scanner(System.in);
//
//        try {
//            System.out.print("Enter a byte size number = ");
//            byte c = in.nextByte();
//            System.out.println("You entered " + c);
//
//            System.out.print("Enter a short size number = ");
//            short d = in.nextShort();
//            System.out.println("You entered " + d);
//
//            System.out.print("Enter a integer number = ");
//            int a = in.nextInt();
//            System.out.println("You entered " + a);
//
//            System.out.print("Enter a float number = ");
//            float b = in.nextFloat();
//            System.out.println("You entered " + b);
//
//            System.out.print("Enter a double number = ");
//            double e = in.nextDouble();
//            System.out.println("You entered " + e);
//
//            System.out.print("Enter a long number = ");
//            long f = in.nextLong();
//            System.out.println("You entered " + f);
//
//            System.out.print("Enter a character = ");
//            char g = in.next().charAt(0);
//            System.out.println("You entered " + g);
//
//            System.out.println("Enter a string = ");
//            String h = in.next();
//            System.out.println("You entered " + h);
//            for (char x : h.toCharArray()) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//            for (int i = 0; i < h.length(); i++) {
//                System.out.print(h.charAt(i) - '0' + " ");
//            }
//
//
//            System.out.println("Enter the array size = ");
//            int n = in.nextInt();
//            int[] num = new int[n];
//            for (int i = 0; i < n; i++) {
//                num[i] = in.nextInt();
//            }
//            System.out.println("You entered " + Arrays.toString(num));
//            for (int x : num) {
//                System.out.print(x + " ");
//            }
//        } catch (Exception e) {
//            System.out.println("Exception");
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void main(String[] args) {
////        InputOutput io=new InputOutput();
////        io.inputOutput();
//        InputOutputTest.inputOutput();
//    }
//
//}
