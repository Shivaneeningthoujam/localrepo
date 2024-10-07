package localrepo.OOP;

abstract class Animal {
    abstract void walk();

    void breathe() {
        System.out.println("Animal breathes air!");
    }

    Animal() {
        // constructor
        System.out.println("You are about to create an Animal.");
    }
}

class Horse extends Animal {
    Horse() {
        System.out.println("Created an animal HORSE.");
    }

    void walk() {
        System.out.println("Horse walks on 4 legs");
    }
}

class Chicken extends Animal {
    Chicken() {
        System.out.println("Created an Animal CHICKEN");
    }

    void walk() {
        System.out.println("Chicken walks on 2 legs");
    }
}

public class Abstract {
    public static void main(String args[]) {
        Horse horse = new Horse();
        horse.walk();
        horse.breathe();
    }

}
