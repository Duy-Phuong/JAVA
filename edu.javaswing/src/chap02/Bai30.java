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
public class Bai30 extends JFrame{  
public Bai30() {  
JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
slider.setMinorTickSpacing(2);  
slider.setMajorTickSpacing(10);  
slider.setPaintTicks(true);  
slider.setPaintLabels(true);  

JPanel panel=new JPanel();  
panel.add(slider);  
add(panel);  
}  
  
public static void main(String s[]) {  
Bai30 frame=new Bai30();  
frame.pack();  
frame.setVisible(true);  
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}  
    
}
