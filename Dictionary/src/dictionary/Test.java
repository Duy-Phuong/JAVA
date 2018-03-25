/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author admin1
 */
public class Test {
    public static void main(String[] args) {
        String fileName = "abc.txt";
        
        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String line = null;
                while((line = b.readLine())!= null){

                      String[] str1 = line.split(":");
                      if(str1.length == 2){
//                    System.out.println(str1[0]);
//                    System.out.println(":::" + str1[1].trim());
                            Data h = new Data(str1[0].trim(), str1[1].trim());
                            //mod.addElement(h.getText());
                          }
                        //phai trim ms parse duoc
                     // Data h = new Data(str1[0].trim(), str1[1].trim());
                     
                      //mod.addElement(h.getText());
//                    System.out.println(h.getText());
//                    System.out.println("- " + h.getDec());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("open file error: file not found");
        } catch (IOException ex) {
             System.out.println("open file error");
        }
    }
}
