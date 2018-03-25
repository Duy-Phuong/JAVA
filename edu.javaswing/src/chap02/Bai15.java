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
public class Bai15 {
    Bai15(){  
        JFrame f= new JFrame();  
        DefaultListModel<String> l1 = new DefaultListModel<>();  
          l1.addElement("Item1");  
          l1.addElement("Item2");  
          l1.addElement("Item3");  
          l1.addElement("Item4");  
          JList<String> list = new JList<>(l1);
          
          list.setBounds(100,100, 75,75);  
          f.add(list);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
          f.setLocationRelativeTo(null);//hiển thị ở giữa screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
     }  
public static void main(String args[])  
    {  
   new Bai15();  
    }
}
