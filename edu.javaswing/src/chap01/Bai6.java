/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01;
import java.awt.*;  
import javax.swing.JFrame;  

/**
 *
 * @author admin1
 */
public class Bai6 extends Canvas{  
      ///ve hinh
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("pic.png");  
        g.drawImage(i, 120,100,this);  
          
    }  
        public static void main(String[] args) {  
        Bai6 m=new Bai6();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(600,600);  
        f.setVisible(true);  
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
        f.setLocationRelativeTo(null);//hiển thị ở giữa screen

    }  
}
