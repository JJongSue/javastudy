package week9;

public class CustomExceptionMain {
    public static <ce> void main(String[] args) {


        try{
            System.out.println("Try");
            CustomExceptionMain cem = new CustomExceptionMain();
            cem.throwCustomException();
        }catch (CustomException ce){
            System.out.println("CustomException Catch");
        }
    }
    public void throwCustomException() throws CustomException{
        System.out.println("throwCustomException()!");
        throw new CustomException();
    }
}

class CustomException extends Exception{
    public CustomException() {
//        //super();
    }
//
    public CustomException(String message) {
//        //super(message);
    }
}
