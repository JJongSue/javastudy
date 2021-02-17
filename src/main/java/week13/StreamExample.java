package week13;

import java.io.*;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        int a = is.read();
        is.close();

        OutputStream os = System.out;
        os.write(a);
        os.flush();
        os.close();

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < ; i++) {
//
//        }

        //System.out.println((char)a);


    }
}
