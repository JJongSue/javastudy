package week8;

public class Week8Main {
    public static void main(String[] args) {
        Computer C = new Notebook();
        C.on();

        C = new Desktop();
        C.on();

        ((Desktop)C).upgrade();


    }
}

class Notebook implements Computer{
    @Override
    public void on() {
        System.out.println("Notebook ON!");
    }
    @Override
    public void off() {
        System.out.println("Notebook Turn OFF");
    }
}

class Desktop implements Computer{

    @Override
    public void on() {
        System.out.println("Desktop On");
    }

    @Override
    public void off() {
        System.out.println("Desktop off");
    }

    public void upgrade(){
        System.out.println("upgrade PC");
    }
}

class SmartPhone extends Note implements Computer, Phone{
    @Override
    public void on() {
        System.out.println("Smart Phone On");
    }

    @Override
    public void off() {
        System.out.println("Smart Phone OFF");
    }

    @Override
    public void call(String phonenum) {
        System.out.println("SmartPhone Call "+ phonenum);
    }
}