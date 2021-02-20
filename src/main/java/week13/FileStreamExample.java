package week13;

import java.io.*;

public class FileStreamExample {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileInputName = null;
        String fileOutputName = null;
        String line = null;

        try {
            fileInputName = br.readLine();
            fileOutputName = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            BufferedReader fbr = new BufferedReader(new FileReader(new File(fileInputName)));
            BufferedWriter fbw = new BufferedWriter(new FileWriter(new File(fileOutputName)));
            while( (line = fbr.readLine()) != null ){
                System.out.println(line);
                fbw.write(line);
                fbw.newLine();
            }
            fbw.flush();


        }catch(FileNotFoundException e){

        }catch(IOException e){

        }



    }
}
