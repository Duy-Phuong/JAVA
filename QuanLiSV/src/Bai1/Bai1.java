/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author admin1
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    private static final String FILE_NAME = "DSHS.csv";
    private static ClassStudent c = new ClassStudent();
    //bien de kiem tra xem file co ton tai noi dung chua
    private static boolean kt = false;
    public static void main(String[] args) {
         // TODO code application logic here
        try (   Scanner sc = new Scanner(System.in)) {
            int i = 0;            
            
            do {
                showMenu();
                i = sc.nextInt();
                sc.nextLine();
                switch(i){
                    case 1:
                        add();
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        list("MHS", 0); //MHS tăng
                        break;
                    case 5:
                        list("MHS", 1);// MHS giảm
                        
                        break;
                    case 6:
                        list("Diem", 0);
                        
                        break;
                    case 7:
                        list("Diem", 1);
                        
                        break;
                    case 8:
                        System.out.println(readLineFile());
                        
                        break;
                    case 9:
                         writeLineFile();
                       
                        break; 
                    case 10:
                         System.out.println("Thoát thành công!");
                        break;                        
                }
            } while (i != 10);
            sc.close();
        }
    }
    
    public static void showMenu() {
        System.out.println("===========QUAN LI SINH VIEN=============");
        System.out.println("1. Thêm học sinh");
        System.out.println("2. Cập nhật thông tin học sinh");
        System.out.println("3. Xóa học sinh");
        System.out.println("4. Xem danh sách học sinh(MHS tăng dần)");
        System.out.println("5. Xem danh sách học sinh(MHS giảm dần)");
        System.out.println("6. Xem danh sách học sinh(Điểm tăng dần)");
        System.out.println("7. Xem danh sách học sinh(Điểm giảm dần)");
        System.out.println("8. Import danh sách học sinh từ file text ");
        System.out.println("9. Export danh sách học sinh ra file text ");
        System.out.println("10. Exit");
        System.out.println("Lựa chọn của bạn là [1-10]: ");

    }
    public static void add() {
        if (c.isFull()) {
            System.out.println("Danh sách lớp đầy");
        } else {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Mời bạn nhập MSH: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Mời bạn nhập tên học sinh: ");
        String name = sc.nextLine();        
        System.out.println("Mời bạn nhập điểm học sinh: ");
        float score = sc.nextFloat();
        sc.nextLine();
        System.out.println("Mời bạn nhập link hình ảnh của học sinh: ");
        String image = sc.nextLine();
        System.out.println("Mời bạn nhập địa chỉ học sinh: ");
        String address = sc.nextLine();
        System.out.println("Ghi chú: ");
        String note = sc.nextLine();   
        HocSinh h = new HocSinh(id, name, score, image, address, note);
        
        c.add(h);
        }
    }
    public static void update() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Mời bạn nhập MSH cần edit: ");
        int id = sc.nextInt();
        sc.nextLine();
        // tim co hs co MHS roi moi lam tiep
        if (c.getPosition(id) != -1) { 
            System.out.println("Mời bạn nhập tên học sinh: ");
            String name = sc.nextLine();        
            System.out.println("Mời bạn nhập điểm học sinh: ");
            float score = sc.nextFloat();
            sc.nextLine();
            System.out.println("Mời bạn nhập link hình ảnh của học sinh: ");
            String image = sc.nextLine();
            System.out.println("Mời bạn nhập địa chỉ học sinh: ");
            String address = sc.nextLine();
            System.out.println("Ghi chú: ");
            String note = sc.nextLine();   
            c.edit(id, name, score, image,  address, note);
        } else {
            System.out.println("Không có hs có MHS đó!");
        }
        

    }
    public static void delete() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Mời bạn nhập MSH: ");
            int num = sc.nextInt();
            sc.nextLine();
            c.delete(num);
          //  sc.close();k close


    }
    public static void list(String content, int type) {
        if(content.equalsIgnoreCase("MHS") && type == 0){
            c.sortIdAZ();
        }
        if(content.equalsIgnoreCase("MHS") && type == 1){
            c.sortIdZA();
        }
        if(content.equalsIgnoreCase("Diem") && type == 0){
            c.sortDiemAZ();
        }
        if(content.equalsIgnoreCase("Diem") && type == 1){
            c.sortDIemZA();
        }
        c.list();

    }
//write file
    public static void writeLineFile() {
        c.writeFile(FILE_NAME, kt);
        kt = false;
    }
        //read file
    public static String readLineFile() {
        kt = true; //co import dô r thì k export phải ghi lại từ đầu vì nó nạp vào list r
            StringBuilder str = new StringBuilder();
        try (FileReader f = new FileReader(FILE_NAME); BufferedReader b = new BufferedReader(f)) {
                String line = null;
                while((line = b.readLine())!= null){
                    //str.append(line).append(System.getProperty("line.separator"));//cách 2
//                    StringTokenizer st = new StringTokenizer(line, "-");
//                    while (st.hasMoreTokens()) {
//                        String s = st.nextToken().trim();
//                        
//                        //System.out.println(st.nextToken().trim());//cat bo khoang tang dau cuoi
//                    }
//                //if(!line.equals("")){
                      String[] str1 = line.split(",");
//                      for (int i = 0; i < 5; i++) {
//                          str1[i].trim();
//                          //System.out.println(str1[i].trim());
//                    }
                        //phai trim ms parse duoc
                      HocSinh h = new HocSinh(Integer.parseInt(str1[0].trim()), str1[1].trim(), Float.parseFloat(str1[2].trim()), str1[3].trim(), str1[4].trim(), str1[5].trim());
                      c.add(h);
//                //}
                    //System.out.println(line);
            }
                b.close();
                f.close();
        } catch (FileNotFoundException ex) {
            System.out.println("open file error: file not found");
        } catch (IOException ex) {
             System.out.println("open file error");
        }
        
        return str.toString();
    }
}
