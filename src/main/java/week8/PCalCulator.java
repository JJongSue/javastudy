package week8;

public interface PCalCulator {
    int minus(int a, int b);
    default int dmul(int a, int b){
        return a*b;
    }
    static int ssum(int a, int b){
        return a+b;
    }
    private static int psminus(int a, int b){
        return a-b;
    }

    private int a2b2(int a, int b){
//        int m = psminus(a,b);
        System.out.println(minus(a,b));
        return dmul(ssum(a,b), psminus(a,b));
    }
    default int get_a2b2(int a, int b){
        return a2b2(a,b);
    }
}
