/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author admin1
 */
public class Demo {
    JFrame f;
    Demo(){
        f = new JFrame("Demo");
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setLayout(null);
        f.setLocationRelativeTo(null);
        
        JLabel l = new JLabel();
        l.setBounds(200, 200, 100, 25);
        
        
         f.setLayout(new GridLayout(0, 1));  
        JLabel l1 = new JLabel("Above Separator");  
        f.add(l1);  
        JSeparator sep = new JSeparator();  
        f.add(sep);  
        JLabel l2 = new JLabel("Below Separator");  
        f.add(l2);  
//        JButton b = new JButton("button");
//        b.setBounds(100, 200, 80, 25);
//        b.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //l.setText("hello");
//                JOptionPane.showMessageDialog(f, "message", "title", JOptionPane.WARNING_MESSAGE);
//            }
//            
//        });
//        
//        f.add(b);
//        f.add(l);
        //b.setEnabled(false);
    }
    public static void main(String[] args) {
        new Demo();
        
    }
}
