package com.example.BasicToAdvance.SOLID.liskupSubs;

// ============== ❌ BAD Approach (Violates LSP) ==============
interface BirdBad {
    void fly();
    void eat();
    void makeSound();
}

class SparrowBad implements BirdBad {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying high!");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow is eating seeds");
    }

    @Override
    public void makeSound() {
        System.out.println("Sparrow: Chirp chirp!");
    }
}

class PenguinBad implements BirdBad {
    @Override
    public void fly() {
        // ❌ PROBLEM: Penguins can't fly!
        // Have to either throw exception or provide dummy implementation
        throw new UnsupportedOperationException("Penguins can't fly!");
        // or
        // System.out.println("Penguin tries to fly... fails!"); // Lie to the compiler
    }

    @Override
    public void eat() {
        System.out.println("Penguin is eating fish");
    }

    @Override
    public void makeSound() {
        System.out.println("Penguin: Honk honk!");
    }
}

// ============== ✅ GOOD Approach (Follows LSP) ==============

// Base interface with common bird behaviors
interface Bird {
    void eat();
    void makeSound();
    void move();  // Generic movement method
}

// Interface for birds that can fly
interface FlyingBird extends Bird {
    void fly();
}

// Interface for birds that can swim
interface SwimmingBird extends Bird {
    void swim();
}

// Interface for birds that can run
interface RunningBird extends Bird {
    void run();
}

// Birds that can fly
class Sparrow implements FlyingBird {
    @Override
    public void eat() {
        System.out.println("Sparrow is eating seeds");
    }

    @Override
    public void makeSound() {
        System.out.println("Sparrow: Chirp chirp!");
    }

    @Override
    public void move() {
        fly();
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying gracefully");
    }
}

class Eagle implements FlyingBird, RunningBird {
    @Override
    public void eat() {
        System.out.println("Eagle is hunting prey");
    }

    @Override
    public void makeSound() {
        System.out.println("Eagle: Screech!");
    }

    @Override
    public void move() {
        System.out.println("Eagle chooses movement mode...");
        // Can decide to fly or run
    }

    @Override
    public void fly() {
        System.out.println("Eagle is soaring high in the sky");
    }

    @Override
    public void run() {
        System.out.println("Eagle is running on the ground");
    }
}

// Birds that can swim
class Penguin implements SwimmingBird, RunningBird {
    @Override
    public void eat() {
        System.out.println("Penguin is eating fish");
    }

    @Override
    public void makeSound() {
        System.out.println("Penguin: Honk honk!");
    }

    @Override
    public void move() {
        swim();  // Penguins prefer swimming
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming fast in cold water");
    }

    @Override
    public void run() {
        System.out.println("Penguin is waddling on ice");
    }
}

class Duck implements FlyingBird, SwimmingBird, RunningBird {
    @Override
    public void eat() {
        System.out.println("Duck is eating plants and small fish");
    }

    @Override
    public void makeSound() {
        System.out.println("Duck: Quack quack!");
    }

    @Override
    public void move() {
        System.out.println("Duck can move in multiple ways");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying in V-formation");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming in the pond");
    }

    @Override
    public void run() {
        System.out.println("Duck is walking on land");
    }
}

// ============== Client Code Demonstrating LSP ==============

class BirdSanctuary {
    // This method accepts ANY Bird - follows LSP
    public void careForBird(Bird bird) {
        System.out.println("\n--- Caring for bird ---");
        bird.eat();
        bird.makeSound();
        bird.move();
    }

    // Special care for flying birds only
    public void letBirdFly(FlyingBird bird) {
        System.out.println("\n--- Letting bird fly ---");
        bird.fly();
    }

    // Special care for swimming birds only
    public void letBirdSwim(SwimmingBird bird) {
        System.out.println("\n--- Letting bird swim ---");
        bird.swim();
    }
}

public class Main {
    public static void main(String[] args) {
        BirdSanctuary sanctuary = new BirdSanctuary();

        System.out.println("=== ❌ BAD Approach Problems ===");
        try {
            BirdBad penguinBad = new PenguinBad();
            penguinBad.fly();  // This will crash or lie!
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " (LSP Violation!)");
        }

        System.out.println("\n=== ✅ GOOD Approach (Following LSP) ===");

        // All these can be treated as generic Birds
        Bird sparrow = new Sparrow();
        Bird eagle = new Eagle();
        Bird penguin = new Penguin();
        Bird duck = new Duck();

        // LSP in action: All Birds can be substituted
        sanctuary.careForBird(sparrow);
        sanctuary.careForBird(eagle);
        sanctuary.careForBird(penguin);
        sanctuary.careForBird(duck);

        System.out.println("\n=== Specialized Behaviors ===");

        // Only flying birds can fly
        sanctuary.letBirdFly(new Sparrow());
        sanctuary.letBirdFly(new Eagle());
        sanctuary.letBirdFly(new Duck());
        // sanctuary.letBirdFly(new Penguin()); // Compile-time error - GOOD!

        // Only swimming birds can swim
        sanctuary.letBirdSwim(new Penguin());
        sanctuary.letBirdSwim(new Duck());
        // sanctuary.letBirdSwim(new Sparrow()); // Compile-time error - GOOD!
    }
}