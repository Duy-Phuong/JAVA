/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileandfolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author admin1
 */
public class Compress {
     public static void main(String[] args) {
        String FILE_PATH = "D:\\study\\tes\\datas.zip";
        String srcPath = "D:\\\\study\\\\tes";
        //String folderName = "datas.zip";
        
        ZipInputStream zipIs = null;
        try {
            // Tạo đối tượng ZipInputStream để đọc file zip.
            zipIs = new ZipInputStream(new FileInputStream(FILE_PATH));
 
            ZipEntry entry = null;
            // Duyệt từng Entry (Từ trên xuống dưới cho tới hết)
            while ((entry = zipIs.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    System.out.print("Directory: ");
                } else {
                    System.out.print("File: ");
                }
                String zipName = entry.getName(); // File: datas/test.txt or datas/
                StringBuffer buf = new StringBuffer(zipName);
                if(buf.charAt(buf.length()-1) == '/'){
                    buf.deleteCharAt(buf.length()-1);
                }
                zipName = buf.toString();
                zipName = zipName.replace("/", "\\\\");
                System.out.println(zipName);
                
                
                zipName = srcPath + "\\\\" + zipName;
                System.out.println("- link: " + zipName);
               
            
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zipIs.close();
            } catch (Exception e) {
            }
        }
    }
     
   
 
}
