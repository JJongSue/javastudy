package week15;

import java.math.BigInteger;
import java.util.function.Function;

public class ReferenceMain {
    public static void main(String[] args) {
        Calc c= new Calc();
        Operator<Integer> oadd = (a, b) -> Calc.add(a,b);
        oadd = Calc::add;
        Operator<Integer> ominus = (a, b) -> c.minus(a, b);
        ominus = c::minus;
        Operator<Integer> ocmp = (a, b) -> a.compareTo(b);
        ocmp = Integer::compareTo;



    }


}
class Calc{
    static int add(int a, int b){
        return a+b;
    }
    int minus(int a, int b){
        return a-b;
    }
}

@FunctionalInterface
interface Operator<N extends Number>{
    int version = 2;
    String name = "Operator";

    N op(N a, N b);
}

