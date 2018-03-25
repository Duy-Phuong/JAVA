/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author admin1
 */
class Bai2 extends JFrame  
{  
  
Bai2(String path)  
{  
super("Windows Exploder");  

add(new Explorer(path),"Center"); 

setDefaultCloseOperation(EXIT_ON_CLOSE);  
setSize(400,400);  
setVisible(true);  
}  
  
public static void main(String[] args)  
{  
new Bai2("D:\\");  
}  
}  