package week6;

abstract class Car{
    public abstract void start();
}
class HD extends Car{

    @Override
    public void start() {
        System.out.println("fast");
    }
}

public class AbastartMain {
}
