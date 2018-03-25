/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;    
import java.awt.event.*;  
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author admin1
 */
public class Edit implements ActionListener{    
        JMenuBar mb;    
        JMenu file,edit,help;    
        JMenuItem cut,copy,paste,selectAll, save;   
        JTextArea ta;
        JFrame f;
        String path = null;// "D:\\study\\tes\\bt.txt";
    Edit(){
        f = new JFrame("Notepad");  
        cut=new JMenuItem("cut");    
        copy=new JMenuItem("copy");    
        paste=new JMenuItem("paste");    
        selectAll=new JMenuItem("selectAll");
        save=new JMenuItem("save");    

        save.addActionListener(this);
        cut.addActionListener(this);    
        copy.addActionListener(this);    
        paste.addActionListener(this);    
        selectAll.addActionListener(this); 
        
        mb=new JMenuBar();    
        file=new JMenu("File");    
        edit=new JMenu("Edit");    
        help=new JMenu("Help");     
        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);    
        mb.add(file);mb.add(edit);mb.add(help);    
        file.add(save);
        f.add(mb, BorderLayout.NORTH);//f.add(ta);    
        f.setJMenuBar(mb); 
        JLabel label = new JLabel("Label");  
        label.setPreferredSize(new Dimension(1000, 1000));  
        JScrollPane jScrollPane = new JScrollPane(label);  
  
        ta = new JTextArea();  
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        //jScrollPane.setViewportBorder(new LineBorder(Color.RED));  
        jScrollPane.getViewport().add(ta, null);  
  
        f.add(jScrollPane, BorderLayout.CENTER); 
        
        f.setSize(500, 500);  
        f.setVisible(true);  
        f.setLocationRelativeTo(null);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
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
    if(e.getSource()==save)    {
        //System.out.println("save");
        if(path!=null)
        writeWithBuffer(ta.getText(), path);
    }
}
//write file with buffer: 
//path Ex: D:\\c.txt
  void writeWithBuffer(String data, String path) { 
        try {
            try (FileOutputStream f = new FileOutputStream(path, false) //F là k ghi tiếp
            ) {
                try (BufferedOutputStream b = new BufferedOutputStream(f)) {
                    b.write(data.getBytes());
                    b.flush();
                }
                f.close();
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("file not found!");
        } catch (IOException ex) {
            System.out.println("write file error!");        }
        
    }
public static void main(String[] args) {    
    new Edit();    
}    
    
}
