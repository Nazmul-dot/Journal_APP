//3. Observer Pattern(Behavioral Patterns)
//Definition: When one object changes, all dependent objects are automatically notified.
//Real-life example: YouTube channel subscription - when a new video is uploaded, all subscribers get notified.

package com.example.BasicToAdvance.Design_Pattern;

import java.util.ArrayList;
import java.util.List;

class Subscriber{
    private String name;
    public static int subscriberCount=0;
    public Subscriber(String name){
        this.name=name;
        subscriberCount++;
    }
    public void update(String channel,String video){
        System.out.println("subscriber = "+name +" is notifyed"+"\n");
        System.out.println(channel+" realised a new video name is ="+video+"\n");

    }
}

class Publisher{
    private List<Subscriber> subscribers=new ArrayList<>();
    private String chennel;
    public Publisher(String channel){
        this.chennel=channel;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void ContentUploaded(String video){
        System.out.println("Content Uploaded to channel ="+chennel+"\n\n");
        notification(video);
    }

    public void notification(String video){
        for(Subscriber subscriber: subscribers){
            subscriber.update(chennel,video);
        }
    }

}

public class Observer {
    public static void main(String[] args) {
        Publisher publisher = new Publisher("amar sarkar");
        Subscriber sb1=new Subscriber("sabbu");
        Subscriber sb2=new Subscriber("bappi");
        Subscriber sb3=new Subscriber("pappu");

        publisher.addSubscriber(sb1);
        publisher.addSubscriber(sb2);
        publisher.addSubscriber(sb3);

        publisher.ContentUploaded("today news : amar bangla");
    }
}
