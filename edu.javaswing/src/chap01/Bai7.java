/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01;
import javax.swing.*;  
import java.awt.event.*;  
/**
 *
 * @author admin1
 */
//edit menu cho notepad

public class Bai7 implements ActionListener{  
JFrame f;  
JMenuBar mb;  
JMenu file,edit,help;  
JMenuItem cut,copy,paste,selectAll;  
JTextArea ta;  
      
Bai7(){  
    f=new JFrame();  

    cut=new JMenuItem("cut");  
    copy=new JMenuItem("copy");  
    paste=new JMenuItem("paste");  
    selectAll=new JMenuItem("selectAll");  

    cut.addActionListener(this);  
    copy.addActionListener(this);  
    paste.addActionListener(this);  
    selectAll.addActionListener(this);  

    mb=new JMenuBar();  
    mb.setBounds(5,5,400,40);  

    file=new JMenu("File");  
    edit=new JMenu("Edit");  
    help=new JMenu("Help");  

    edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);  


    mb.add(file);mb.add(edit);mb.add(help);  

    ta=new JTextArea();  
    ta.setBounds(5,30,460,460);  

    f.add(mb);f.add(ta);  

    f.setLayout(null);  
    f.setSize(500,500);  
    f.setVisible(true);  
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
    f.setLocationRelativeTo(null);//hiển thị ở giữa screen
}  
  
public void actionPerformed(ActionEvent e) {  
    if(e.getSource()==cut)  
    ta.cut();  
    if(e.getSource()==paste)  
    ta.paste();  
    if(e.getSource()==copy)  
    ta.copy();  
    if(e.getSource()==selectAll)  
    ta.selectAll();  
}  
public static void main(String[] args) {  
    new Bai7();  
}  
}
