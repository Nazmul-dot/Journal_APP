package com.example.BasicToAdvance.basicjava;

import java.util.PriorityQueue;


class Pair{
    Integer first;
    Integer second;
    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}
public class PriorityQ {
    public static void simplePriorityQueue(){
//        min heap => min priority
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(40);
        pq.add(50);
        pq.add(10);
        pq.add(20);
        pq.add(30);
        System.out.println(pq.poll());

//        max heap => max priority
        PriorityQueue<Integer> pq2=new PriorityQueue<>((a,b)->b-a);
        pq2.add(40);
        pq2.add(50);
        pq2.add(10);
        pq2.add(20);
        pq2.add(30);
        System.out.println(pq2.poll());
    }

    public static void pairPriorityQueue(){
//        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.first-b.first); //accending sort by first element
//        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.first-a.first); //decending  sort by first element
//        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.second-b.second); //accending sort by second element
//        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.second-a.second); //decending  sort by second element
          PriorityQueue<Pair> pq=new PriorityQueue<>(
                  (a,b)->{
                      if(a.first==b.first){
                          return a.second-b.second;
                      }
                      return a.first-b.first;
                  }
          ); // if first elements are same then sort by second element
        pq.add(new Pair(40,10));
        pq.add(new Pair(50,20));
        pq.add(new Pair(10,30));
        pq.add(new Pair(20,40));
        pq.add(new Pair(30,50));
//        System.out.println(pq.poll());
        System.out.println("polling");
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            System.out.println(p.first+" ->"+p.second);
        }
    }
  public static void main(String[] args) {
    System.out.println("Hello World");
    simplePriorityQueue();
    pairPriorityQueue();
  }
}
