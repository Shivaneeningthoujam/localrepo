package localrepo.OOP;

//ABSTRACTION
abstract class Animal {
    // abstract classes can have abstract methods as well as non abs methods
    // Abstract classes and methods must use the keyword 'abstract'
    abstract void walk();// only declaration ,need not be defined

    void breathe() {
        System.out.println("Animals breathes air");
    }
}

class Horse extends Animal {
    Horse() {
        System.out.println("Created an animal ,Horse!");
    }

    void walk() {
        System.out.println("Horse walks on 4 legs");
    }
}

class Chicken extends Animal {
    Chicken() {
        System.out.println("Created an animal , Chicken!");
    }

    void walk() {
        System.out.println("Chicken walks on 2 legs");
    }
}

class Elephant extends Animal {
    Elephant() {
        System.out.println("Created an animal ,Elephant!");

    }

    void walk() {
        System.out.println("Elephant walks on 4  legs");
    }
}
