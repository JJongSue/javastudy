package week9;

import java.io.*;

public class TryWithResource {
    static void copy(String src, String dest) throws IOException{
        /*try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dest)){
            byte[] buf = new byte[1024];
            int n;
            while((n = in.read(buf)) != 0){
                out.write(buf, 0, n);
            } /*catch(IOException){

            }
        }*/
        InputStream in = null;
        OutputStream out = null;
        try {
            out = new FileOutputStream(dest);
            try {
                in = new FileInputStream(src);
                byte[] buf = new byte[1024];
                int n;
                while ((n = in.read(buf)) != 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {

                    }
                }
            }
        }finally{
                try{
                    out.close();
                }catch (IOException e){

                }
            }

    }
}
