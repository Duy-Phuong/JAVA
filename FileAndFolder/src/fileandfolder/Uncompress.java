/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileandfolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author admin1
 */
public class Uncompress {
     public static void main(String[] args) {
        final String outputFolder = "D:\\study\\test\\datas";
        String filePath = "D:\\study\\test\\datas.zip";
 
         Uncompress1(filePath, outputFolder);
    }
     
     public static void Uncompress1(String filePath, String outputFolder) {
        // Tạo thư mục Output nếu nó không tồn tại.
        File folder = new File(outputFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // Tạo một buffer (Bộ đệm).
        byte[] buffer = new byte[1024];
 
        ZipInputStream zipIs = null;
        try {
            // Tạo đối tượng ZipInputStream để đọc file từ 1 đường dẫn (path).
            zipIs = new ZipInputStream(new FileInputStream(filePath));
 
            ZipEntry entry = null;
            // Duyệt từng Entry (Từ trên xuống dưới cho tới hết)
            while ((entry = zipIs.getNextEntry()) != null) {
                String entryName = entry.getName();
                String outFileName = outputFolder + File.separator + entryName;
                System.out.println("Unzip: " + outFileName);
 
                if (entry.isDirectory()) {
                    // Tạo các thư mục.
                    new File(outFileName).mkdirs();
                } else {
                    // Tạo một Stream để ghi dữ liệu vào file.
                    FileOutputStream fos = new FileOutputStream(outFileName);
 
                    int len;
                    // Đọc dữ liệu trên Entry hiện tại.
                    while ((len = zipIs.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
 
                    fos.close();
                }
 
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
