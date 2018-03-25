/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin1
 */
public class FileIOStream {
    public static void main(String[] args) {
//        write("file output stream");
//        System.out.println("noi dung file: " + read());
            cut("file_Output_Stream.txt", "file1.txt", "file2.txt");

//            String pathA = "logo.png";
//            String pathB = "logo_copy.png";
//            copy(pathA, pathB);

//          writeWithBuffer("buffer output stream");
//            System.out.println(readWithBuffer());
    }
    //write file
    public static void write(String data) {
        try {
            try (FileOutputStream f = new FileOutputStream("file_Output_Stream.txt", false) //F là k ghi tiếp
            ) {
                f.write(data.getBytes());
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
        try (FileInputStream f = new FileInputStream("file_Output_Stream.txt")) {
            //System.out.println(f.available()); so ki tu doc vao dk
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
    //cut file 
    public static void cut(String path, String pathSubFile1, String pathSubFile2) {
            StringBuilder str = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
        try (FileInputStream f = new FileInputStream(path)) {
            //System.out.println(f.available()); so ki tu doc vao dk
            int n = f.available()/2;
            int dem = 0;
                int i = 0;
                while((i = f.read())!= -1){
                    if(dem < n){
                        str.append((char)i);
                    }
                    else{
                        str2.append((char)i);
                    }
                    dem++;
            }
                f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //write to subFile
        writeSubFile(pathSubFile1, str.toString());
        writeSubFile(pathSubFile2, str2.toString());

    }
    //write file
    public static void writeSubFile(String path, String data) {
        try {
            try (FileOutputStream f = new FileOutputStream(path, false) //F là k ghi tiếp
            ) {
                f.write(data.getBytes());
                f.close();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //copy image
    public static void copy(String pathA, String pathB) {
        try (FileInputStream f = new FileInputStream(pathA)) {
            FileOutputStream f1; //F là k ghi tiếp
            f1 = new FileOutputStream(pathB);

                int i = 0;
                while((i = f.read())!= -1){
                    f1.write((byte)i);
            }
                f1.close();
                f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //BufferedStream 
    public static String readWithBuffer() {
            StringBuilder str = new StringBuilder();
        try (FileInputStream f = new FileInputStream("Buffer_Output_Stream.txt"); BufferedInputStream b = new BufferedInputStream(f)) {
                int i = 0;
                while((i = b.read())!= -1){
                    str.append((char)i);
                }
             f.close();
             b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str.toString();
    }
    
    public static void writeWithBuffer(String data) {
        try {
            try (FileOutputStream f = new FileOutputStream("Buffer_Output_Stream.txt", false) //F là k ghi tiếp
            ) {
                try (BufferedOutputStream b = new BufferedOutputStream(f)) {
                    b.write(data.getBytes());
                    b.flush();
                }
                f.close();
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIOStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
