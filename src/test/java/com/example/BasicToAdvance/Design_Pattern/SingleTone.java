//1. Singleton Pattern(Creational Patterns)
//Definition: Ensures only ONE instance of a class exists in the entire application.
//Real-life example: A country can have only one president at a time.

package com.example.BasicToAdvance.Design_Pattern;

class Database{
    private static Database instance;
    private Database(){
        System.out.println("Database is created");
    }

    public static Database getInstance(){
        if(instance==null){
            instance=new Database();
        }
        return instance;
    }
    public void qureyRun(String sql){
        System.out.println("perform sql query ="+sql);
    }
}

public class SingleTone {
    public static void main(String args[]){
        Database db1=Database.getInstance();
        Database db2=Database.getInstance();
        if(db1==db2){
            System.out.println("Same instance");
        }
        db1.qureyRun("select * from employee");
    }
}
