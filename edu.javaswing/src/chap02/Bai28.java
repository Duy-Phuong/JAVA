/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import java.awt.event.*;    
import java.awt.*;    
import javax.swing.*; 
/**
 *
 * @author admin1
 */
public class Bai28  extends JFrame implements ActionListener {    
JButton b;    
Container c;    
Bai28(){    
    c=getContentPane();    
    c.setLayout(new FlowLayout());         
    b=new JButton("color");    
    b.addActionListener(this);         
    c.add(b);    
}    
public void actionPerformed(ActionEvent e) {    
Color initialcolor=Color.RED;    
Color color=JColorChooser.showDialog(this,"Select a color",initialcolor);    
c.setBackground(color);    
}    
    
public static void main(String[] args) {    
    Bai28 ch=new Bai28(); 
    ch.setTitle("title");
    ch.setSize(400,400);    
    ch.setVisible(true);    
    ch.setDefaultCloseOperation(EXIT_ON_CLOSE);    
}    
    
}
