/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02.file;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin1
 */
public class FileText {
    private static final String FILE_NAME = "FileWriter.txt";
    private static final String FILE_NAME1 = "File_Line.txt";

    public static void main(String[] args) {
//        write("-File Writer-");
//        System.out.println(read());

//            writeLineFile();
//System.out.println(readLineFile());
    }
    
    //write file
    public static void write(String data) {
        try {
            try (FileWriter f = new FileWriter(FILE_NAME, false) //F là k ghi tiếp
            ) {
                f.write(data);
                f.close();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //read file
    public static String read() {
            StringBuilder str = new StringBuilder();
        try (FileReader f = new FileReader(FILE_NAME)) {

                int i = 0;
                while((i = f.read())!= -1){
                    str.append((char)i);
            }
                f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str.toString();
    }
    
    //doc ghi file theo tưng dong
    
    //write file
    public static void writeLineFile() {
        try {
            try (FileWriter f = new FileWriter(FILE_NAME1, false) //F là k ghi tiếp
            ) {
                PrintWriter p = new PrintWriter(f);
                p.println("java");
                p.println("is");
                p.println("easy");
                
                p.close();
                f.close();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //read file
    public static String readLineFile() {
            StringBuilder str = new StringBuilder();
        try (FileReader f = new FileReader(FILE_NAME1); BufferedReader b = new BufferedReader(f)) {
                String line = null;
                while((line = b.readLine())!= null){
                    str.append(line).append(System.getProperty("line.separator"));//cách 2
                    
            }
                b.close();
                f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return str.toString();
    }
}
