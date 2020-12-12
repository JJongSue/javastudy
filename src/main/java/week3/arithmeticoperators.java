package week3;

public class arithmeticoperators {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        /*
        기본적인 연산자
        + - * / %
         */
        System.out.println("a = "+ a + " b = " + b);
        System.out.println("a + b = "+ (a+b) );
        System.out.println("a - b = " + (a-b));
        System.out.println("a / b = " + (a/b));
        System.out.println("a * b = " + (a*b));
        System.out.println("a % b = " + (a%b));
        //System.out.println(a/0);
        //System.out.println(a%0);
        System.out.println("0 / a = " + 0/a);

        /*
        전위/후위 연산자
        ++, --
         */
        System.out.println("\n\n\n 전위/후위");

        System.out.println("a = " + a);
        System.out.println("++a " + ++a);
        System.out.println("a = " + a);

        System.out.println();
        System.out.println("a = " + a);
        System.out.println("a++ "+a++);
        System.out.println("a = " + a);

        System.out.println();
        System.out.println("a = " + a);
        System.out.println("--a " + --a);
        System.out.println("a = " + a);

        System.out.println();
        System.out.println("a = " + a);
        System.out.println("a-- "+a--);
        System.out.println("a = " + a);

    }
}
