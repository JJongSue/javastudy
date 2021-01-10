package week9;

public class ExceptionExample {
    public static void main(String[] args) {
        
        try{
//            ArrayException ae = new ArrayException();
//            System.out.println(ae.array[0]);

        } catch (Exception e) {
            System.out.println("error 발생");
        }
    }
}

class ArrayException{
    int array[];

    public ArrayException() {
        array = new int[3];
        array[4] = 0;
    }
}
