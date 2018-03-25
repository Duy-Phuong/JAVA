/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import javax.swing.*;  
import java.awt.event.*;  
/**
 *
 * @author admin1
 */
public class Bai22 {
    Bai22(){  
         final JFrame f= new JFrame("PopupMenu Example");  
         final JPopupMenu popupmenu = new JPopupMenu("Edit");   
         JMenuItem cut = new JMenuItem("Cut");  
         JMenuItem copy = new JMenuItem("Copy");  
         JMenuItem paste = new JMenuItem("Paste");  
         popupmenu.add(cut); popupmenu.add(copy); popupmenu.add(paste);        
         f.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {              
                popupmenu.show(f , e.getX(), e.getY());  
            }                 
         });  
         f.add(popupmenu); 
          final JLabel label = new JLabel();          
         label.setHorizontalAlignment(JLabel.CENTER);  
         label.setSize(400,100);  
         f.add(label);
         f.setSize(300,300);  
         f.setLayout(null);  
         f.setVisible(true);  
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
cut.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e) {              
             label.setText("cut MenuItem clicked.");  
         }  
        });  
        copy.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {              
                label.setText("copy MenuItem clicked.");  
            }  
           });  
        paste.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e) {              
                label.setText("paste MenuItem clicked.");  
            }  
           });  
     }  
public static void main(String args[])  
{  
        new Bai22();  
}
}
