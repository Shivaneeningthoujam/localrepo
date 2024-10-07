package localrepo.OOP;

//Inheritance
//1.Single Inheritance
public class Shape {
    public void area() {
        System.out.println("displays area");
    }

}

class Triangle extends Shape {
    // method overriding
    public void area(int l, int h) {
        System.out.println(1 / 2 * l * h);
    }
}

// 2.Multilevel Inheritance- 1 class inherits another,another class inherits the
// prev child
class equilateralTriangle extends Triangle {
    public void area(int l, int h) {
        System.out.println(1 / 2 * l * h);
    }
}

// 3.Hierarchical Inheritance-Same base class ,many children
class Circle extends Shape {
    public void area(int r) {
        System.out.println((3.14) * r * r);
    }
}
// NOTE : Mutiple inheritance is only achieved through interfaces in JAVA
