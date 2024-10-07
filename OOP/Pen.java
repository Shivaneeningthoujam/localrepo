package localrepo.OOP;

public class Pen {
    String type;
    String color;

    public void write() {
        System.out.println("Writing something..");
    }

    public void printColor() {
        // use of this keyword
        System.out.println(this.color);
    }

    public static void main(String[] args) {
        // demonstrates classes and objects
        Pen pen1 = new Pen();
        pen1.color = "Blue";
        pen1.type = "gel pen";
        pen1.write();
        pen1.printColor();

    }
}