package week15;

public class VarableCaptureMain {
    static int sa = 10;
    public static void main(String[] args) {
        int A = 10;
        int b = 10;
        FIAdd<Integer> fia = (a) -> sa*a;
        System.out.println(fia.add(10));

        sa = 20;
        System.out.println(fia.add(10));
    }
}

@FunctionalInterface
interface FIAdd <N>{
    N add(N input);
}
