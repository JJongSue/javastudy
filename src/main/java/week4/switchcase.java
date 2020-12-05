package week4;

public class switchcase {
    public static void main(String[] args) {
        String str = "hi";
        switch (str){
            case "hi":
            case "HI":
                System.out.println("HI");
                break;
            case "Hello":
                System.out.println("Hello");
            case "HELL":
                System.out.println("HELL");
                break;
            default:
                System.out.println("default");

        }
    }
}
