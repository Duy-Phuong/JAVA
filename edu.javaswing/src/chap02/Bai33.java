/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import javax.swing.*;    
import java.awt.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author admin1
 */
public class Bai33 {
    public static void main(String[] args) {  
        JFrame frame = new JFrame("Tabbed Pane Sample");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
        JLabel label = new JLabel("Label");  
        label.setPreferredSize(new Dimension(1000, 1000));  
        JScrollPane jScrollPane = new JScrollPane(label);  
  
        //JButton jButton1 = new JButton();  
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        //jScrollPane.setViewportBorder(new LineBorder(Color.RED));  
        //jScrollPane.getViewport().add(jButton1, null);  
        JTextArea jt = new JTextArea();
  jScrollPane.getViewport().add(jt, null);
        frame.add(jScrollPane, BorderLayout.CENTER);  
        frame.setSize(400, 150);  
        frame.setVisible(true);  
    }  
}
