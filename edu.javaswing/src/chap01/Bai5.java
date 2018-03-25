/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap01;
import javax.swing.*;
/**
    @vietjack
 */
public class Bai5 {
    JFrame f;  

    Bai5(){
        f=new JFrame("Button example");//Tao instance cua JFrame  

        JButton b=new JButton("click");//Tao instance cua JButton  
        b.setBounds(130,100,100, 40);  // vi tri button x, y , width, height

        f.add(b);//Them button vao trong JFrame  

        f.setSize(400,500);//Do rong la 400 va chieu cao la 500  
        f.setLayout(null);//Khong su dung Layout Manager  
        f.setVisible(true);//Tao Frame la co the nhin thay (visible)
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat

    }
    public static void main(String[] args) {
        new Bai5();
    }
    
}
