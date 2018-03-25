/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import java.awt.event.*;  
import javax.swing.*;    

public class Bai1 {
    public static void main(String[] args) {  
    JFrame f=new JFrame("Button Example");  
    final JTextField tf=new JTextField();  
    tf.setBounds(50,50, 150,20);  
    //JButton b=new JButton("Click Here"); 
    JButton b=new JButton(new ImageIcon("pic.png"));  

    b.setBounds(50,100,95,20);  
    b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
                tf.setText("Welcome to Javatpoint.");  
            }  
        });  
        f.add(b);f.add(tf);  
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
        f.setLocationRelativeTo(null);//hiển thị ở giữa screen

    }  
    
}
