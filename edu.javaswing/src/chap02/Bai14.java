/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap02;
import javax.swing.*;    
import javax.swing.event.*;
/**
 *
 * @author admin1
 */
public class Bai14 {
    public static void main(String[] a) {  
            JFrame f = new JFrame("Table Example");  
            String data[][]={ {"101","Amit","670000"},    
                              {"102","Jai","780000"},    
                              {"101","Sachin","700000"}};    
            String column[]={"ID","NAME","SALARY"};    
            
           final JTable jt=new JTable(data,column);    
            jt.setCellSelectionEnabled(true); ///chọn cột nó hiện lên
            
            ListSelectionModel select= jt.getSelectionModel();  
            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
            
            select.addListSelectionListener(new ListSelectionListener() { 
                                
              public void valueChanged(ListSelectionEvent e) {
                  String Data = null;
                int[] row = jt.getSelectedRows();  
                int[] columns = jt.getSelectedColumns();  
                int i, j;
                for (i = 0; i < row.length; i++) {  
                  for (j = 0; j < columns.length; j++) { 
                     
                    Data = (String) jt.getValueAt(row[i], columns[j]);  
                  } 
                }  
               Data = (String) jt.getValueAt(row[0], 0);  

                System.out.println(Data);    

              } 

            });  
            
            JScrollPane sp=new JScrollPane(jt);    
            f.add(sp);  
            f.setSize(300, 200);  
            f.setVisible(true);
            f.setLocationRelativeTo(null);//hiển thị ở giữa screen
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//no tu dong tat
          }  
}
