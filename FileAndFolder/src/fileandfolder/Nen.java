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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
 
public class Nen {
 
    public Nen() {
 
    }
 
    // Phương thức dùng để nén một thư mục.
    public static void zipDirectory(File inputDir, File outputZipFile) {
        // Tạo thư mục cha cho file đầu ra (output file).
        outputZipFile.getParentFile().mkdirs();
 
        String inputDirPath = inputDir.getAbsolutePath();
        byte[] buffer = new byte[1024];
 
        FileOutputStream fileOs = null;
        ZipOutputStream zipOs = null;
        try {
 
            List<File> allFiles = Nen.listChildFiles(inputDir);
 
            // Tạo đối tượng ZipOutputStream để ghi file zip.
            fileOs = new FileOutputStream(outputZipFile);
            // 
            zipOs = new ZipOutputStream(fileOs);
            for (File file : allFiles) {
                String filePath = file.getAbsolutePath();
 
                System.out.println("Zipping " + filePath);
                // entryName: is a relative path.
                String entryName = filePath.substring(inputDirPath.length() + 1);
 
                ZipEntry ze = new ZipEntry(entryName);
                // Thêm entry vào file zip.
                zipOs.putNextEntry(ze);
                // Đọc dữ liệu của file và ghi vào ZipOutputStream.
                FileInputStream fileIs = new FileInputStream(filePath);
 
                int len;
                while ((len = fileIs.read(buffer)) > 0) {
                    zipOs.write(buffer, 0, len);
                }
                fileIs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuite(zipOs);
            closeQuite(fileOs);
        }
 
    }
 
    private static void closeQuite(OutputStream out) {
        try {
            out.close();
        } catch (Exception e) {
        }
    }
 
    // Phương thức này trả về danh sách các file,
    // bao gồm tất cả các file con,.. của thư mục đầu vào.
    public static List<File> listChildFiles(File dir) throws IOException {
        List<File> allFiles = new ArrayList<File>();
 
        File[] childFiles = dir.listFiles();
        for (File file : childFiles) {
            if (file.isFile()) {
                allFiles.add(file);
            } else {
                List<File> files = Nen.listChildFiles(file);
                allFiles.addAll(files);
            }
        }
        return allFiles;
    }
 
    public static void main(String[] args) {
        //Nen zipDir = new Nen();
 
        File inputDir = new File("D:\\study\\test\\datas");
        File outputZipFile = new File("D:\\study\\test\\datas.zip");
 
        zipDirectory(inputDir, outputZipFile);
 
    }
}
