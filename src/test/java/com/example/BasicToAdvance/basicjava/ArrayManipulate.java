package com.example.BasicToAdvance.basicjava;

import java.util.*;
public class ArrayManipulate {


    void arrayManipulate(){
        Scanner in=new Scanner(System.in);
        int[] arr={1,2,3,4,5,6,7,8,9,10};
//        int [] arr2={1,6,7,8,9,10};
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

        System.out.println("Enter the array size = ");
        int n2=in.nextInt();
        int[] arr2=new int[n2];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("Enter the string array size = ");
        n=in.nextInt();
        String [] strs=new String[n];
        for(int i=0;i<n;i++){
            strs[i]=in.next();
        }
        for(int i=0;i<n;i++){
            System.out.print(strs[i]+ " ");
        }
        System.out.println();
        for(String s: strs){
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("sort the array = ");
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("sort the string array = ");
        Arrays.sort(strs);
        for(String s: strs){
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("sort substring array = ");
        // Sort subarray (fromIndex inclusive, toIndex exclusive)
        Arrays.sort(arr, 2, 5);
        System.out.println(Arrays.toString(arr));
        System.out.println();



        System.out.println("reverse the array = ");
        Collections.reverse(Arrays.asList(arr));
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("reverse the string array = ");
        Collections.reverse(Arrays.asList(strs));
        for(String s: strs){
            System.out.print(s+" ");
        }
        System.out.println();

        System.out.println("Decending order = ");
        Arrays.sort(arr);
        Collections.reverse(Arrays.asList(arr));
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("Decending order of string array = ");
        Arrays.sort(strs,Collections.reverseOrder());
        for(String s: strs){
            System.out.print(s+" ");
        }


        System.out.println("binary search = ");
        int indx=Arrays.binarySearch(arr,5);
        System.out.println(indx);

        System.out.println("binary search of substring array = ");
        indx=Arrays.binarySearch(arr,5,2,5);
        System.out.println(indx);
        System.out.println();

        System.out.println("binary search of string array = ");
        indx=Arrays.binarySearch(strs,"6");
        System.out.println(indx);


        System.out.println("array comparator = ");
        boolean comp=Arrays.equals(arr,arr2);
        System.out.println(comp);

        System.out.println("copy of array = ");
        int[] arr3=Arrays.copyOf(arr,arr.length);
        for(int i=0;i<arr3.length;i++){
            System.out.print(arr3[i]+ " ");
        }
        System.out.println();

        System.out.println("copy of subarray = ");
        int[] arr4=Arrays.copyOfRange(arr,2,5);
        for(int i=0;i<arr4.length;i++){
            System.out.print(arr4[i]+ " ");
        }
        System.out.println();

        System.out.println("fill array = ");
        Arrays.fill(arr,10);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("fill subarray = ");
        Arrays.fill(arr,2,5,10);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("clear array = ");
        Arrays.fill(arr,0);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

        System.out.println("is empty = ");
        boolean empty= arr.length == 0 || arr == null;
        System.out.println(empty);
        System.out.println();




    }
}
