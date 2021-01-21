package week10;

public class ThreadMain {
    public static void main(String[] args) {
        ImplThread it = new ImplThread();
        new Thread(it).start();

        ExtendsThread et = new ExtendsThread();
        et.start();
        for (int i = 0; i < 10; i++) {
            new NameThread(Integer.toString(i)).start();
        }
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

class NameThread extends Thread{
    NameThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(NameThread.currentThread().getName() + " is Run");
    }
}
