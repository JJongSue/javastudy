package week8;

public class CalcMain {
    public static void main(String[] args) {
        AbsCalculator ac = new AbsCalculator();
        System.out.println(ac.exe(-5, 6));
        System.out.println(ac.exe2(-5,6));
        System.out.println(Calculator.exe2(-5, 6));

        MyCalculator mc = new MyCalculator();
        System.out.println(mc.get_a2b2(2,3));

    }
}
class AbsCalculator implements Calculator{

    @Override
    public int plus(int a, int b) {
        return Math.abs(a)+Math.abs(b);
    }

    public int exe2(int a, int b){
        return a+b;
    }



}

class MyCalculator implements PCalCulator{

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}
