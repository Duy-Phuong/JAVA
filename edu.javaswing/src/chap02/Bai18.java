/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import javax.swing.*;  

/**
 *
 * @author admin1
 */
public class Bai18 {
    Bai18(){  
JFrame f= new JFrame("Scrollbar Example");  
JScrollBar s=new JScrollBar();  
s.setBounds(100,100, 25,200);  
f.add(s);  
f.setSize(400,400);  
f.setLayout(null);  
f.setVisible(true);  
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}  
public static void main(String args[])  
{  
new Bai18();  
}
}
