package week6;


public class extendsMain {
    public static void main(String[] args) {
        Person person = new Person();
        person.run();

        Student student = new Student();
        student.run();
        student.study();

        Runner runner = new Runner();
        runner.run();
    }
}
