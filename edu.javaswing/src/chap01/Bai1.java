/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01;

import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author admin1
 */
public class Bai1 {
    private JFrame frame;
    JButton button;
    public Bai1(){
        create();
    }
    public static void main(String[] args) {
        new Bai1();
    }

    private void create() {
        //khi extends thì bỏ dòng đầu
        frame = new JFrame("Bai 01");//title là nội dung truyền vào
        frame.setSize(500, 400);
        
        frame.setLocationRelativeTo(null);//hiển thị ở giữa screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
        
        button = new JButton("OK");
        frame.add(button);
        frame.setLayout(new FlowLayout());
        
        //frame.pack();//tao vừa đủ để hiển thị nút ok nếu k SD setsize 
        frame.setVisible(true);//hiển thị lên
    }
}
