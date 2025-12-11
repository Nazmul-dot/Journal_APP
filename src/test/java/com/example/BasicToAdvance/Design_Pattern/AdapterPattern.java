//✅ 5. Adapter Pattern (Structural Patterns)
//⭐ Simple Definition:
//Adapter makes two incompatible things work together.
//Adapter converts one type into another type.
//Real-life example: USB cable to old charger - you can connect USB to old charger.


package com.example.BasicToAdvance.Design_Pattern;

interface USB{
    void USBconnect();
}

class OldCharger{

    public void connectOldCharger(){
        System.out.println("Old Charger is connected");
    }
}

class Adapter implements USB{

    OldCharger old;
    public Adapter(OldCharger old){
        this.old=old;
    }

    @Override
    public void USBconnect() {
        System.out.println("via USB");
        old.connectOldCharger();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        OldCharger oldCharger=new OldCharger();

        Adapter adapter=new Adapter(oldCharger);
        adapter.USBconnect();
    }
}
