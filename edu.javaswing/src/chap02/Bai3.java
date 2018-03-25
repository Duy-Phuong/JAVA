/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
/**
 *
 * @author admin1
 */
public class Bai3  extends JFrame implements ActionListener{  
    JTextField tf; JLabel l; JButton b;  
    Bai3(){  
        tf=new JTextField();  
        tf.setBounds(50,50, 150,20);  
        l=new JLabel();  
        l.setBounds(50,100, 250,20);      
        b=new JButton("Find IP");  
        b.setBounds(50,150,95,30);  
        b.addActionListener(this);    
        add(b);add(tf);add(l);    
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
        this.setLocationRelativeTo(null);//hiển thị ở giữa screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
        
    }  
    public void actionPerformed(ActionEvent e) {  
        try{  
        String host=tf.getText();  
        String ip=java.net.InetAddress.getByName(host).getHostAddress();  
        l.setText("IP of "+host+" is: "+ip);  
        }catch(Exception ex){System.out.println(ex);}  
    }  
    public static void main(String[] args) {  
        new Bai3();  
    } 
}
