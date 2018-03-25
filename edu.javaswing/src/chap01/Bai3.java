/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin1
 */
public class Bai3 extends JFrame implements ActionListener{
    JButton buttonOk;
    JButton buttonExit, buttonCancel ;
    public Bai3(){
        create();
    }
    public static void main(String[] args) {
        new Bai3();
    }

    private void create() {
        //khi extends thì bỏ dòng đầu
 
        this.setSize(500, 400);
        this.setTitle("Bai 03");
        this.setLocationRelativeTo(null);//hiển thị ở giữa screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
        
        buttonOk = new JButton("OK");
        buttonExit = new JButton("EXIT");
        buttonCancel = new JButton("CANCEL");
        
        this.add(buttonOk);
        this.add(buttonCancel);
        this.add(buttonExit);
        this.setLayout(new FlowLayout());
        
        buttonOk.setActionCommand("ok");
        buttonOk.addActionListener(this);
        buttonOk.setMnemonic(KeyEvent.VK_O);//ấn alt O
        buttonOk.setToolTipText("click vào để ấn OK");
        
        buttonCancel.setActionCommand("cancel");
        buttonCancel.addActionListener(this);

        buttonExit.setActionCommand("exit");
        buttonExit.addActionListener(this);

        //this.pack();//tao vừa đủ để hiển thị nút ok nếu k SD setsize 
        this.setVisible(true);//hiển thị lên
           //để thay đổi chữ label SD method setText(); vs hình thì có setVisible()
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("ok".equalsIgnoreCase(e.getActionCommand()))
            JOptionPane.showMessageDialog(rootPane, "Bạn vừa nhấp nút OK");
        if("cancel".equalsIgnoreCase(e.getActionCommand()))
            JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát không?");
        if("exit".equalsIgnoreCase(e.getActionCommand()))
            System.exit(0);
        
    }
}
