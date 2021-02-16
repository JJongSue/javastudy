package week13;

import java.io.BufferedInputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        InputStream is = new BufferedInputStream(System.in);
        int a = is.read();
        while(a != -1){
            System.out.println(a);
            a = is.read();
        }


    }
}
