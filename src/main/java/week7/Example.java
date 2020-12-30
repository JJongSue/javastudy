package week7;
//import week7.p1.*;
import week7.p1.hi;

import static java.lang.Math.abs;

//import week7.p1.StaticClass;
//import static week7.p1.StaticClass.*;
import static week7.p1.StaticClass.print;
public class Example {

    public static void main(String[] args) {
        hi h = new hi();
        h.hello();
        Like li = new Like();
        li.IL();
//        int a = Math.abs(-1);
        int a = abs(-1);

//        StaticClass.print();
        print();
    }

}
