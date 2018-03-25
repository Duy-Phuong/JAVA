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
public class Bai2 {
public static void main(String args[])  
    {  
    JFrame f= new JFrame("Label Example");  
    JLabel l1,l2;  
    l1=new JLabel("First Label.");  
    l1.setBounds(50,50, 100,30);  
    l2=new JLabel("Second Label.");  
    l2.setBounds(50,100, 100,30);  
    //text field
    JTextField t1,t2;  

    t1=new JTextField("Welcome to Javatpoint.");  
    t1.setBounds(160,50, 200,30);  
    t2=new JTextField("AWT Tutorial");  
    t2.setBounds(160,100, 200,30);  
    f.add(t1); f.add(t2); 
//    //text area
//     JTextArea area=new JTextArea("Welcome to javatpoint");  
//        area.setBounds(50,150, 200,100); 
//        area.insert("---", 0);
//        f.add(area);  
//    ///passwordField
//     JPasswordField value = new JPasswordField();   
//     JLabel l=new JLabel("Password:");    
//        l.setBounds(50,260, 80,30);    
//         value.setBounds(120,260,100,30);    
//            f.add(value);  f.add(l);  
    //check box
     JCheckBox checkBox1 = new JCheckBox("C++");  
        checkBox1.setBounds(100,300, 100,40);  
        JCheckBox checkBox2 = new JCheckBox("Java", true);  
        checkBox2.setBounds(100,330, 100,40);  
        f.add(checkBox1);  
        f.add(checkBox2);  
    //
    f.add(l1); f.add(l2);  
    f.setSize(500,500);  
    f.setLayout(null);  
    f.setVisible(true);  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    }  
}
