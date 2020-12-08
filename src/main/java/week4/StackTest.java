package week4;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        ArrayStack arraystack = new ArrayStack();
        Stack<Integer> stack = new Stack<>();
        arraystack.add(5);
        stack.add(5);

        arraystack.add(8);
        stack.add(8);

        arraystack.add(12);
        stack.add(12);

        while(!arraystack.is_empty()){
            int as = arraystack.pop();
            int s = stack.pop();
            if ( as != s) System.out.println("실패 실제 : "+ s + " 값 : " + as);
            else System.out.println("성공 " + as);
        }
    }
}
