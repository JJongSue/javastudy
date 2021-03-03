package week9;

public class CustomExceptionMain {
    public static <ce> void main(String[] args) throws CustomException {

        CustomExceptionMain cem = new CustomExceptionMain();
        cem.throwCustomException();

    }
    public void throwCustomException() throws CustomException{
        System.out.println("throwCustomException()!");
        throw new CustomException("CustomExecption!");
    }
}

class CustomException extends Exception{
    public CustomException() {
        super();
    }
//
    public CustomException(String message) {
        super(message);
    }
}
