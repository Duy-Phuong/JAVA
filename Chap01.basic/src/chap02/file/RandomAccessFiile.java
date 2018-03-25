/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin1
 */
public class RandomAccessFiile {
    private static RandomAccessFile f;
    private static String name = null;
    private static int score = 0;
    private static int SIZE = 36;
    public static void main(String[] args) {
               // userInput();
               // write(name, score);
                read();
                System.out.println("----------Search------------");
                System.out.println("ket qua: " + search("JoHN"));
               update("abc", 8);
               System.out.println("-----------Update-----------");
               read();
               
    }
    public static void userInput() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Name: ");
            name = sc.next();
            System.out.println("Score: ");
            score = sc.nextInt();
            System.out.println("--------");
        }
    }
    //write file
    public static void write(String name, int score) {

       
        // System.out.println("Name: " + name + "  ----   Score:" + score);
        try {
            
            f = new RandomAccessFile("Chap02_random_file.dat", "rw");
                //di chuyen toi cuoi ghi tiep
                long fileSize = f.length();
                f.seek(fileSize);
                
                f.writeUTF(name);
                //ghi cho đủ 30 bytes
                for (int i = 0; i < 30 - name.length(); i++) {
                f.writeByte(30);
                
            }
                f.writeInt(score);
                f.close();
   
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        name = "";
        
       
    }
    //read file
    public static void read() {
        try {
                f = new RandomAccessFile("Chap02_random_file.dat", "r");
                //lay ra so SV để đọc
                int soSV = (int)f.length()/SIZE; 
                for (int j = 0; j < soSV; j++) {
                 String studentName = f.readUTF();
                for (int i = 0; i < 30 - studentName.length(); i++) {
                f.readByte();
                
                 }
                int studentScore = f.readInt();
                
                
               // System.out.println("kich thuoc file: " + f.length());

                System.out.println("- name: " + studentName);
                System.out.println("- score: " + studentScore);

                
                }
               
                f.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    //search
     public static String search(String searchName) {
         StringBuilder str = new StringBuilder();
        try {
                f = new RandomAccessFile("Chap02_random_file.dat", "r");
                //lay ra so SV để đọc
                int soSV = (int)f.length()/SIZE; 
                for (int j = 0; j < soSV; j++) {
                 String studentName = f.readUTF();
                for (int i = 0; i < 30 - studentName.length(); i++) {
                f.readByte();
                
                 }
                int studentScore = f.readInt();
                
                
               // System.out.println("kich thuoc file: " + f.length());
//
//                System.out.println("content: " + studentName);
//                System.out.println("content: " + studentScore);
                if(studentName.equalsIgnoreCase(searchName)){
                    str.append(studentName).append(" : ").append(studentScore).append("\n");
                }
                
                }
               
                f.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        }
       return str.toString();
    }
     //update
     public static void update(String searchName, int value) {
        try {
                f = new RandomAccessFile("Chap02_random_file.dat", "rw");//doc va ghi
                //lay ra so SV để đọc
                int soSV = (int)f.length()/SIZE; 
                for (int j = 0; j < soSV; j++) {
                 String studentName = f.readUTF();
                for (int i = 0; i < 30 - studentName.length(); i++) {
                f.readByte();
                
                 }
                
                if(studentName.equalsIgnoreCase(searchName)){
                    f.writeInt(value);
                }else{
                    f.readInt();
                }
                   
                
                }
               
                f.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFiile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
