/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
import javax.swing.border.LineBorder;
/**
 *
 * @author admin1
 */
public class Bai27 implements ActionListener{
    JMenuBar mb;    
        JMenu file,edit,help;    
        JMenuItem cut,copy,paste,selectAll;   
        JTextArea ta;
        JFrame f;// = new JFrame("View/Edit");  
    Bai27(){
        f = new JFrame("Notepad");  
        cut=new JMenuItem("cut");    
        copy=new JMenuItem("copy");    
        paste=new JMenuItem("paste");    
        selectAll=new JMenuItem("selectAll");    
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
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

    }
    public static void main(String[] args) {  
        new Bai27();
    }  

    @Override
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
}
