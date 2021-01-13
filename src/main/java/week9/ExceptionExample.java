package week9;

public class ExceptionExample {
    public static void main(String[] args) {

        try{
            ArrayException ae = new ArrayException();
            ae.makeException();
//            System.out.println(ae.array[0]);

            throw new ArrayIndexOutOfBoundsException("Array");
//            throw new Exception("exception");

        }catch (NullPointerException e){
            System.out.println("|");

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("error 발생");
        } finally {
            System.out.println("finally");
        }
    }
}

class ArrayException{
    int array[];

    public ArrayException() {
        array = new int[3];
//        array[4] = 0;
    }

    void makeException() throws Exception {
        throw new Exception("make Exeption");
    }
}

