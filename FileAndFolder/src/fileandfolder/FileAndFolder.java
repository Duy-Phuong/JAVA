/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileandfolder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.shape.Path;

/**
 *
 * @author admin1
 */
public class FileAndFolder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // new File("Directory1").mkdir(); //D:\\Directory1; C:\\Directory2\\Sub2\\Sub-Sub2
       // boolean mkdirs = new File("C:\\Directory2\\Sub2\\Sub-Sub2").mkdirs();
       File file = new File("Directory1");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        File files = new File("Directory2\\Sub2\\Sub-Sub2");
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
//        StringBuffer buf = new StringBuffer("study\\");
//        if(buf.charAt(buf.length()-1) == '\\') // vd D:\\study\ khi chen se du dau
//    {
//        System.out.println("true: " );
//        buf.deleteCharAt(buf.length()-1);
//        System.out.println(buf);
//    }
//    else{
//            System.out.println("false");
//            }
//    
    }
    
}
