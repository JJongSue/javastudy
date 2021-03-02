package week15;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaExample {
    public static void main(String[] args) {
        Calculate c = new Calculate<Integer>(){
            @Override
            public Integer operation(Integer a, Integer b){
                return a+b;
            }
        };
        Calculate<Integer> c2 = (a, b) -> a+b;
        Predicate<Long> p = (t) -> t>5 ? true:false;
        Supplier<String> s = () -> "Hello Wolrd";
        System.out.println(s.get());
    }
}
@FunctionalInterface
interface Calculate<T>{
    T operation(T a, T b);
}
