package week4;

public class ArrayStack {
    private int size = 16;
    private int[] Stack = new int[size];
    private int now = 0;

    boolean is_full(){
        return size == now;
    }
    boolean is_empty(){
        return size == 0;
    }
    void sizeUP(){
        int tmp[] = new int[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = Stack[i];
        }
        Stack = new int[(size<<1)];
        for (int i = 0; i < size; i++) {
            Stack[i] = tmp[i];
        }
        size <<= 1;
    }

    void add(int input){
        if(is_full()) sizeUP();
        Stack[now++] = input;
    }

    int pop(){
        if(is_empty()){
            System.out.println("empty");
            return -1;
        }
        return Stack[now--];
    }
}
