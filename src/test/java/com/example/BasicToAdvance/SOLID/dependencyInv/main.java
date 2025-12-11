package com.example.BasicToAdvance.SOLID.dependencyInv;

interface Database{
    void save();
}
class MySqlDatabase implements Database{

    @Override
    public void save() {
        System.out.println("MySQL save");
    }
}

class PostgresDatabase implements Database{
    @Override
    public void save() {
        System.out.println("Postgres save");
    }
}

// ❌ BAD - Violates Dependency Inversion Principle
class DatabaseManager {
    private MySqlDatabase database;

    public DatabaseManager(MySqlDatabase database) {
        this.database = database;
    }
    public void save() {
        database.save();
    }
}


// ✅ GOOD - Follows Dependency Inversion Principle
class DatabaseManagerDIP {
    private Database database;

    public DatabaseManagerDIP(Database database) {
        this.database = database;
    }
    public void save() {
        database.save();
    }
}
public class main {
    public static void main(String[] args) {
        DatabaseManagerDIP databaseManager = new DatabaseManagerDIP(new PostgresDatabase());
        databaseManager.save();
    }
}
