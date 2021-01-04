package week8;

public interface Calculator {
    public int plus(int a, int b);
    default int exe(int a, int b){
        return a+b;
    }
    static int exe2(int a, int b){
        return a-b;
    }

    private int a2b2(int a, int b){
        return exe(a,b)*(exe2(a,b));
    }
}
