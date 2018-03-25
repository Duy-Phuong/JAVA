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
public class Bai11 {
    JFrame f;    
Bai11(){    
    f=new JFrame("ComboBox Example");    
    String country[]={"India","Aus","U.S.A","England","Newzealand"};        
    JComboBox cb=new JComboBox(country);    
    cb.setBounds(50, 50,90,20);    
    f.add(cb);        
    
    f.setLayout(null);    
    f.setSize(400,500);    
    f.setVisible(true);        
    f.setLocationRelativeTo(null);//hiển thị ở giữa screen
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
}    
public static void main(String[] args) {    
    new Bai11();         
}    
}
