package week10;

public class ThreadMain {
    public static void main(String[] args) {
        ImplThread it = new ImplThread();
        //it.start();

        ExtendsThread et = new ExtendsThread();
        et.start();
    }
}

class ImplThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Runable Thread가 생성되었습니다.");
    }
}

class ExtendsThread extends Thread{
    @Override
    public void run(){
        System.out.println("ExtendsThread가 생성되었습니다.");
    }
}
