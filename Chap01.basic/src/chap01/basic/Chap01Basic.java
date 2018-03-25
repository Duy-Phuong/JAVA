/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author admin1
 */
public class Chap01Basic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        Calendar c = Calendar.getInstance();
        System.out.println("now: " + c.get(Calendar.YEAR));
       
//        write();
//        read();

        readwrite();
    }
    
    //mang 1 chiều
    public static void main001() {
                /*
        String[] arr = new String[]{ "a", "b", "c"};
        String[] brr = Arrays.copyOf(arr, arr.length);
        System.out.println("Mang b:");
        for(String t : brr)
        {
            System.out.println(t);
        }
        String[] crr = Arrays.copyOfRange(arr, 0, arr.length);
        System.out.println("Mang c:");
        for(String t : crr)
        {
            System.out.println(t);
        }*/
        
        //sort increase
        System.out.println("------------------------------");
        int[] a1 = {3, 5, 0, -2};
        Arrays.sort(a1);
        System.out.println("Mang sau khi sort tang dan: " + Arrays.toString(a1));
        // sort decrease
        for (int i = 0; i < a1.length / 2; i++) {
            int temp = a1[i];
            a1[i] = a1[a1.length - 1 - i];
            a1[a1.length - 1 - i] = temp;
            
        }
       // Arrays.fill(a1, 0);
        System.out.println("Mang sau khi sort giam dan: " + Arrays.toString(a1));
        
        
                
    }
    //Math, nhập chuỗi đơn giản
    public static void main002() {
                int a = 10;
        int b = 20;
        float c = 12.5f;
        System.out.println("max: " + Math.max(a, b));
        System.out.println("round: " + Math.round(c));
        
        

                
                
        //Random từ 14 -> 19
        int max = 14;
        int min = 19;
        int range = (max - min)+1;
        int random = 0;
        random = (int)(Math.random() * range) + min;
        System.out.println("random = " + random);
        System.out.println("-----------------------------");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập số: ");
        int num = sc.nextInt();
        sc.nextLine(); ///bỏ qua dấu \n
        System.out.println("num = " + num);
        System.out.println("Mời bạn nhập chuỗi: ");
        String s = sc.nextLine();
        System.out.println("string = " + s);
        sc.close();
        
         System.out.println("-----------------------------");
        DecimalFormat f =  new DecimalFormat("#,###");
        System.out.println("so tien: " + f.format(15000000));
    }
    //mảng 2 chiều
    public static void main003() {
         //mang 2 chieu
        int[][] a = new int[][]{
            {1, 2, 3}
            ,{4, 5, 6}
        };
        int row = a.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("a[%d, %d] = %d   ", i, j, a[i][j]);
                
            }
            System.out.print("\n");
        }
    }
    //try catch finally
    public static void main004() {
        int a = 5;
        int b = 0;
        float c = 0f;
        int[] d = {1, 2};
        try {
            c = (float)a / b;
            a = d[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("ket qua: " + c);
        
    }

    @Override
    public boolean equals(Object obj) {
        //phai ép kiểu lại
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Arrays List
    public static void main005() {
        List a = new ArrayList();
        a.add("java");
        a.add(1);
        a.add(true);
        a.add(12.5);
        //a.get();//tra ra obj phải ép
        a.set(0, "Java");
        //duyet
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//            
//        }
        
       //duyet c2
//       for(Object t : a){
//           System.out.println(t);
//       }
        

        //duyet c3
        Iterator i = a.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        
        a.remove(a.size() - 1);
        System.out.println("==================================");
        if(!a.isEmpty()){
            Iterator i1 = a.iterator();
        while(i1.hasNext()){
            System.out.println(i1.next());
        }
        }else{
            System.out.println("is empty");
        }
        
        a.clear(); // xóa hết
    }
    //HashSet
    public static void main006() {
        Set a = new HashSet();
        a.add("java");
        a.add(1);
        a.add(true);
        a.add(12.5);
        a.add(1);
        


        //duyet c3
        Iterator i = a.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        
        System.out.println("==================================");
        if(!a.isEmpty()){
            Iterator i1 = a.iterator();
        while(i1.hasNext()){
            System.out.println(i1.next());
        }
        }else{
            System.out.println("is empty");
        }
        
        a.clear(); // xóa hết
    }
    //hashMap
        public static void main007() {
        Map a = new HashMap();
        a.put("001", "java");
        a.put("002", "web");
        a.put("003", "di dong");
        a.put("004", "toan");
        a.put("001", "Java");
        

        System.out.println(a.toString());
        //duyet c3
        Iterator i = a.keySet().iterator();
        while(i.hasNext()){
            Object key = i.next();
            Object value = a.get(key);
            System.out.println(key + " : " + value);
        }
        
        System.out.println("==================================");

    }
        private static final String FILE_NAME = "file\\bo.txt";
        private static final String FOLDER_NAME = "file";

    //File
        public static void main008(String s) {
        File f = new File(FOLDER_NAME);
        if(f.exists()){
            System.out.println("getAbsolutePath" + f.getAbsolutePath());
            System.out.println("folder chứa tập tin: " + f.getParent());
            System.out.println("can Read: " + f.canRead());
            System.out.println("can Write: " + f.canWrite());
            System.out.println("length: " + f.length());
            Date day = new Date(f.lastModified());
            System.out.println("lastModified " + day);
            
            System.out.println("isDirectory: " + f.isDirectory());
            System.out.println("isFile: " + f.isFile());
            //f.delete();//xoa file
            
            System.out.println("==================================");
            File[] listFile = f.listFiles();
            System.out.println("number of file: " + listFile.length);
            System.out.println("==================================");
            for (int i = 0; i < listFile.length; i++) {
                File filetmp = listFile[i];
                System.out.println("name: " + filetmp.getName());
                
            }
        }else{
            try {
                 System.out.println("not exist");
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Chap01Basic.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
       
    }
    //RandomAccessFile
        public static void write() {
        try {
            try (RandomAccessFile f = new RandomAccessFile("randomfile.txt", "rw")) {
                f.writeInt(123);
                f.writeBoolean(true);
                f.writeUTF("noi dung file");
                f.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chap01Basic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Chap01Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        public static void read() {
        try {
            try (RandomAccessFile f = new RandomAccessFile("randomfile.txt", "r")) {
                
                System.out.println("content: " + f.readInt());
                System.out.println("content: " + f.readBoolean());
                System.out.println("content: " + f.readUTF());
                f.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chap01Basic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Chap01Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    //read write
        public static void readwrite() {
        try {
            try (RandomAccessFile f = new RandomAccessFile("randomfile.txt", "rw")) {
                f.writeInt(123);
                f.writeBoolean(true);
                f.writeUTF("noi dung file");
                f.seek(0);
                System.out.println("content: " + f.readInt());
                System.out.println("content: " + f.readBoolean());
                System.out.println("content: " + f.readUTF());
                f.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chap01Basic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Chap01Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
