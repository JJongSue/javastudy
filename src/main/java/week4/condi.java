package week4;

public class condi {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        if ( a == 1) System.out.println("a는 1");
        if ( b == 1 ) System.out.println("b는 1");
        if (a == 1 || b == 1) System.out.println("a 또는 b가 1");
        if (++a == 2 || ++b == 1) System.out.println("a : " + a + " " + "b : " +b);


        a = 5;
        b = 2;
        if ( a == 1) System.out.println("a는 1");
        else if ( a == 2) System.out.println("a는 2");
        else if ( a == 3) System.out.println("a는 3");
        else if ( a == 4) System.out.println("a는 4");
        else  System.out.println("a는 5이상의 수");

        if ( ++a == 7 ) System.out.println("a : " + a);
        else if(++a == 7) System.out.println("a : " + a);
        else if(++a == 10) System.out.println("a : " + a);
        else System.out.println("a : " + a);

        if (a == 8) System.out.println("a는 8");
        else if (a == 9) System.out.println("a는 9");

        if (a == 7) System.out.println("a는 7");
        else System.out.println("a는 7이 아님");


//        if( a == 1)
    }

}
