/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javaswing;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author admin1
 */
public class EduJavaswing extends JFrame{

    /**
     * @param args the command line arguments
     */
    public EduJavaswing(){
        this.setSize(400, 300);
        setVisible(true);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Hello java Swing");
        add(label);
        setResizable(false);
        
        label.setText("Viet Nam");
        label.setToolTipText("A beutiful country");//khi rê chuột vào nó sẽ hiện
        label.setForeground(Color.GREEN);
        
        label.setSize(300, 200);
        System.out.println("x = " + label.getSize().width + ", y = " + label.getSize().height);
        
       /* ImageIcon icon = new ImageIcon("pic.png");
        label.setIcon(icon);*/
    }
    public static void main(String[] args) {
        // TODO code application logic here
        EduJavaswing e = new EduJavaswing();
        //e.setVisible(true);
    }
    
}
