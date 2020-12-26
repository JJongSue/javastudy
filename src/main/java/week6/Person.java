package week6;

public class Person {
    int age = 20;
    static int si = 5;

    public Person() {
        System.out.println("Person 생성자");
    }

    void run(){
        System.out.println("slow");
    }

    static void staticI(){
        System.out.println(si);
    }
    void printSI(){
        System.out.println(si);
    }
}
