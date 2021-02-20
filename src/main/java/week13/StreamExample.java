package week13;

import java.io.*;

public class StreamExample {
    public static void main(String[] args) throws IOException {
//        InputStream is = System.in;
//        int a = is.read();
////        is.close();
//
////        OutputStream os = System.out;
////        os.write((char)a);
////        os.flush();
////        os.close();
//        System.out.println((char)a);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int b = br.read();
            System.out.println((char)b);
        }catch (IOException e){
            System.out.println("IOException!");
        }

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < ; i++) {
//
//        }

        //System.out.println((char)a);


    }
}
