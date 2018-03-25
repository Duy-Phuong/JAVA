/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01;

import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;  
import java.io.*;  

//Tạo Open Dialog Box sử dụng Java Swing

public class Bai8 extends JFrame implements ActionListener{  
JMenuBar mb;  
JMenu file;  
JMenuItem open;  
JTextArea ta;  
Bai8(){  
open=new JMenuItem("Open File");  
open.addActionListener(this);  
          
file=new JMenu("File");  
file.add(open);  
          
mb=new JMenuBar();  
mb.setBounds(0,0,800,20);  
mb.add(file);  
          
ta=new JTextArea(800,800);  
ta.setBounds(0,20,800,800);  
          
add(mb);  
add(ta);  
          
}  
public void actionPerformed(ActionEvent e) {  
if(e.getSource()==open){  
openFile();  
}  
}  
      
void openFile(){  
JFileChooser fc=new JFileChooser();  
int i=fc.showOpenDialog(this);  
          
if(i==JFileChooser.APPROVE_OPTION){  
File f=fc.getSelectedFile();  
String filepath=f.getPath();  
              
displayContent(filepath);  
              
}  
          
}  
  
void displayContent(String fpath){  
try{  
BufferedReader br=new BufferedReader(new FileReader(fpath));  
String s1="",s2="";  
              
while((s1=br.readLine())!=null){  
s2+=s1+"\n";  
}  
ta.setText(s2);  
br.close();  
}catch (Exception e) {e.printStackTrace();  }  
}  
  
public static void main(String[] args) {  
    Bai8 om=new Bai8();  
    om.setSize(800,800);  
    om.setLayout(null);  
    om.setVisible(true);  
    om.setDefaultCloseOperation(EXIT_ON_CLOSE);  
}  
}  

