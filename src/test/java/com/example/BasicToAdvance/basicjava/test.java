package com.example.BasicToAdvance.basicjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test {
    public static void main(String args[]){
        System.out.println("Hello World");
        List<Integer> list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>(10);
        List<Integer> list3=new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        list1.add(200);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        list1.add(2,100);
        list2.addAll(list1);
        for (Integer integer : list2) {
            System.out.println(integer);
        }
        System.out.print("\n");
        for (Integer integer : list3) {
            System.out.println(integer);
        }
        System.out.print("\n");
        for(int i=0;i<list2.size();i++){
            System.out.print(list2.get(i)+" ");
        }

        boolean isCntains=list1.contains(50);
        if(isCntains){
            System.out.println("Contains");
        }
        else{
            System.out.println("Not Contains");
        }

        int index = list1.indexOf(20);   // primitive int
        int rmv = 0;

        if (index != -1) {
            rmv = list1.remove(2);  // remove by index
            System.out.println("Removed:" + rmv);
        }

        list1.sort(Comparator.comparing(Integer::intValue));
        System.out.println('\n');
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        list1.sort(Comparator.reverseOrder());
        System.out.println('\n');
        for (Integer integer : list1) {
            System.out.println(integer);
        }

        List<Integer> list4=new ArrayList<>(Arrays.asList(1, 3, 2, 4,1, 5,2));
        System.out.println('\n');
        for(int i=0;i<list4.size();i++){
            int indx=Math.abs(list4.get(i));
            if(list4.get(indx)<0){
                System.out.println("duplicate ="+Math.abs(list4.get(i)));
                break;
            }else{
                list4.set(indx,-list4.get(indx));
            }
        }

        System.out.println('\n');
        Integer[] arr =list3.toArray(new Integer[0]);

        int [] arr2=new int[list3.size()];

        for(int i=0;i<list3.size();i++){
            arr2[i]=list3.get(i);
        }

        List<Integer> list5=new ArrayList<>(Arrays.asList(arr));

        List<Integer> list6=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));


        int lower=0;
        int higher=list6.size()-1;
        int val=7;
        boolean flag=false;
        while(lower<=higher){
            int mid=(lower+higher)/2;
            if(list6.get(mid)==val){
                System.out.println("Found");
                flag=true;
                break;
            }
            else if(list6.get(mid)>val){
                higher=mid-1;
            }else{
                lower=mid+1;
            }
        }
        if(!flag){
            System.out.println("Not Found");
        }


    }
}
