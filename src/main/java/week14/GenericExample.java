package week14;

import java.util.ArrayList;

public class GenericExample {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);
        int a = (int)al.get(0);

        ArrayList<Integer> al2 = new ArrayList();
        al2.add(1);
        int b = al2.get(0);
    }
}
