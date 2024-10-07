package localrepo.OOP;

public class Student {
    // to demonstrate types of constructor
    String name;
    int age;

    // Polymorphism: method overloading,Same method name different parameters
    // Compile time polymorphism,more advantage
    public void printInfo(String name) {
        System.out.println(this.name);

    }

    public void printInfo(int age) {

        System.out.println(this.age);

    }

    public void printInfo(String name, int age) {
        System.out.println(this.name);
        System.out.println(this.age);
    }

    // Student() {
    // //this constructor gets printed before the printinfo method
    // //bcz constructors get called automatically when an object is created
    // System.out.println("Non parameterized constructor called!");
    // }

    // Parameterised constructor
    // Student(String name, int age) {
    // this.name = name;
    // this.age = age;
    // }

    // Copy constructor
    // Student(Student s2) {
    // this.name = s2.name;
    // this.age = s2.age;
    // }

    // Student() {

    // }

    public static void main(String[] args) {
        // Student s1 = new Student("jf", 76);
        Student s1 = new Student();
        s1.name = "Shiav";
        s1.age = 23;
        s1.printInfo(s1.age);
        s1.printInfo(s1.name);
        s1.printInfo(s1.name, s1.age);
        // Student s2 = new Student(s1);
        // s2.printInfo();

    }
}
