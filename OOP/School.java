package localrepo.OOP;

//To learn the keyword 'static' of JAVA
public class School {
    String name;
    static String school;

    // create a static method
    public static void ChangeSchool() {
        school = "newSchool";
    }

    public static void main(String[] args) {
        // we can call the static methods without creating any object
        School.school = "JNV";
        Student student1 = new Student();
        student1.name = "Arun";
        System.out.println(student1.name);
    }
}
