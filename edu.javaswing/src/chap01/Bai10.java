/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01;
import java.awt.event.*;  
import javax.swing.*;  
  
//Button with images
public class Bai10{  
Bai10(){  
JFrame f=new JFrame();  
                  
          
JButton b=new JButton(new ImageIcon("pic.png"));  
b.setBounds(130,100,100, 40);  
      
f.add(b);  
          
f.setSize(300,400);  
f.setLayout(null);  
f.setVisible(true);  
          
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          
    }  
      
public static void main(String[] args) {  
    new Bai10();  
}  
}  