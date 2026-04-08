package com.example.BasicToAdvance.SOLID.dependencyInv;


//🔹 D — Dependency Inversion Principle (DIP)
//👉 Depend on abstraction (interface), not concrete class.


interface Database{
    void connect();
}
class MySqlDatabase implements Database{

    @Override
    public void connect() {
        System.out.println("MySQL connect");
    }
}

class PostgresDatabase implements Database{
    @Override
    public void connect() {
        System.out.println("Postgres connect");
    }
}

// ❌ BAD - Violates Dependency Inversion Principle
class DatabaseManager {
//    private MySqlDatabase database;
//
//    public DatabaseManager(MySqlDatabase database) {
//        this.database = database;
//    }
//    public void connect() {
//        database.connect();
//    }

    public void connect(Object database){
        if(database instanceof  MySqlDatabase){
            ((MySqlDatabase)database).connect();
        }
        else if(database instanceof PostgresDatabase){
            ((PostgresDatabase)database).connect();
        }
        else{
            System.out.println("Invalid database type");
        }
    }
}


// ✅ GOOD - Follows Dependency Inversion Principle
class DatabaseManagerDIP {
//    private Database database;
//
//    public DatabaseManagerDIP(Database database) {
//        this.database = database;
//    }
//    public void connect() {
//        database.connect();
//    }

    public void connect(Database database){
        database.connect();
    }
}
 class MongodbDatabase implements Database{
    @Override
    public void connect(){
        System.out.println("MongoDB connect");
    }
}
public class main {
    public static void main(String[] args) {
        //bad
//        DatabaseManager databaseManager = new DatabaseManager(new MySqlDatabase());
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.connect(new MySqlDatabase());
        databaseManager.connect(new PostgresDatabase());

        //good
//        DatabaseManagerDIP databaseManager = new DatabaseManagerDIP(new PostgresDatabase());
        DatabaseManagerDIP databaseManagerD = new DatabaseManagerDIP();
        databaseManagerD.connect(new PostgresDatabase());
        databaseManagerD.connect(new MySqlDatabase());
    }
}
