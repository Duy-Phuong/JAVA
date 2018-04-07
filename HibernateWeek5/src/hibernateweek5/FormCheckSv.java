/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateweek5;

import dao.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import pojo.*;

public class FormCheckSv extends JPanel implements TableModelListener,ActionListener  {
    private boolean DEBUG = false;
    JTable table;
    static JButton j;
    static List<SinhVien> ds = null;
    static String tenMon = "";
    static MyTableModel model;
    static String listSv = ""; //danh sách sv trong mon do có rồi
    static String listSvUpdate = ""; // danh sách sv sau khi tick
    static JMenu file = new JMenu("File");
    static JMenuItem add = new JMenuItem("Add");
    static JMenuItem change = new JMenuItem("Change subject name");
    static JMenuItem exit = new JMenuItem("Exit");
    JScrollPane scrollPane;
   
    static MonHoc v2 = null;
    static  JFrame frame;
    static FormCheckSv newContentPane;
    public FormCheckSv() {
        super(new GridLayout(1,0)); //khi kéo nó k bị giãn
         add.addActionListener(this);    
         change.addActionListener(this); 
         exit.addActionListener(this); 
        model = new MyTableModel();
        //
        //kiem tra ma mon hop le
        MonHoc v=null;
         
        v=MonHocDAO.layThongTinMonHoc(tenMon);
          
        //neu co mon hoc
        if(v != null){
          
            if(v.getMaSinhVien() == null){
                 System.out.println("empty");
            }else{
                //neu mon hoc co sinh vien roi
                listSv =  v.getMaSinhVien();
                //System.out.println("list: " + listSv);
                 listSvUpdate = listSv; // khoi tao cho no nhung sv co roi    

            }
        }
                //them ds sv tu bang sv
       ds = SinhVienDAO.layDanhSachSinhVien();
       if(ds != null){
        for(int i=0; i<ds.size(); i++){
        SinhVien sv=ds.get(i);
        //them sv vao table
          model.insertRow(new SinhVienStatus(sv.getMaSinhVien(), sv.getHoTen(), listSv.contains(sv.getMaSinhVien())));
        
          System.out.println("========info=======");
            System.out.println("Mã SV: " + sv.getMaSinhVien());
           // System.out.println(sv.getSoSvAccount());
            SvAccount c = sv.getIdsvaccount();
//            System.out.println("Tên: " + sv.getHoTen());
//            System.out.println("pass: " + c.getPassword());
//            System.out.println("name: " + c.getUsername());
        }

       }else{
           System.out.println("error");
       }
        
        
         
       
      // model.insertRow(new SinhVienStatus("1", "heelo", true));
      //  model.insertRow(new SinhVienStatus("2", "AS", true));
        
         table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
        
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
//khi check
    public void tableChanged(TableModelEvent e) {
        System.out.print("Row: ");
        int a = table.getSelectedRow();
        int b = table.getSelectedColumn();
        System.out.print(a);
        System.out.print(" - Colum: ");
        System.out.print(b);
        System.out.print(" - Value: ");
        System.out.println(table.getValueAt(a, 2));
        if((boolean)table.getValueAt(a, b) == true){
            listSvUpdate = listSvUpdate + " " + table.getValueAt(a, 0);
        }else{
            String find = (String)table.getValueAt(a, 0);
            if(listSvUpdate.contains((String)table.getValueAt(a, 0))){
            StringBuffer buff = new StringBuffer(listSvUpdate);
            buff.delete(listSvUpdate.indexOf(find), listSvUpdate.indexOf(find) + 2);
            listSvUpdate = buff.toString().trim();
            }
             if(listSvUpdate.contains((String)table.getValueAt(a, 0))){
            //tim lai 1 lan nua neu co
            StringBuffer buff1 = new StringBuffer(listSvUpdate);
            buff1.delete(listSvUpdate.indexOf(find), listSvUpdate.indexOf(find) + 2);
            listSvUpdate = buff1.toString().trim();
             }
        }
        System.out.println("list update: " + listSvUpdate);
    }
    
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Mã Sinh Viên",
        "Họ và tên",
        "Đã có trong lớp"};
       
        Vector data = new Vector(10000);

        
        /* ADDED MORE */
        public void insertRow(SinhVienStatus c)
        {
            data.add(c);
        }
        
        public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            
            return data.size();
        }
        
        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
        
        public Object getValueAt(int row, int col) {
            //return data[row][col];
            SinhVienStatus c = (SinhVienStatus)data.get(row);
            
            switch(col) {
                case 0:
                    return c.getMaSinhVien();
                case 1:
                    return c.getTenSinhVien();
                case 2:
                    return c.isAvaliable();
            }
            
            return null;
        }
        

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
 
        @Override
        public boolean isCellEditable(int row, int col) {

            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }
        

        @Override
        public void setValueAt(Object value, int row, int col) {
//            if (DEBUG) {
//                System.out.println("Setting value at " + row + "," + col
//                        + " to " + value
//                        + " (an instance of "
//                        + value.getClass() + ")");
//            }
            
            //data[row][col] = value;
            SinhVienStatus c = (SinhVienStatus)data.get(row);
            switch(col) {
                case 0:
                    c.setMaSinhVien((String)value);
                    break;
                case 1:
                    c.setTenSinhVien((String)value);
                    break;
                case 2:
                    c.setAvaliable((Boolean)value);
                    break;
            }
            
            data.set(row, c);
            
            fireTableCellUpdated(row, col);
 
    }
    
    }
    private static void createAndShowGUI(String tenMon) {
        //Create and set up the window.
        frame = new JFrame("Table Add SV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
      
        //Display the window.
        frame.pack();
        frame.setVisible(true);
     
        frame.setSize(400,400);  
        frame.setLocationRelativeTo(null);
        
        

            file.add(add);
            file.add(change);
             file.add(exit);
            JMenuBar mb = new JMenuBar();
            mb.add(file);
            frame.add(mb);
            frame.setLayout(new BorderLayout());  
             
              //Create and set up the content pane.
        newContentPane = new FormCheckSv();
        //newContentPane.setOpaque(true); //content panes must be opaque
        frame.add(newContentPane);
//       
        frame.add(mb,BorderLayout.NORTH);  

        j = new JButton(tenMon);
//        frame.setLayout(new BorderLayout());  
//        frame.add(j,BorderLayout.NORTH);  
//        frame.add(j,BorderLayout.WEST);  
//        frame.add(j,BorderLayout.CENTER);  
        frame.add(j,BorderLayout.SOUTH);  
       
        //kiem tra ma mon hop le
       v2 = MonHocDAO.layThongTinMonHoc(tenMon);
          
        //neu co mon hoc
        if(v2 != null){
            j.setForeground(Color.green);
            
        }else{
            JOptionPane.showMessageDialog(null, "Mã môn không hợp lệ bạn có thể thay đổi trong menu");
            j.setText("EMPTY! You must change the subject name in menu");
            j.setForeground(Color.red);
        }

    }
    public void actionPerformed(ActionEvent ev){
         if(ev.getSource()==add){
             //thêm và sửa mon hoc

            v2.setMaSinhVien(listSvUpdate);
            boolean kq1 = false;
            if(v2.getMaSinhVien()!=null || v2.getMaSinhVien().equals("") != true){
                kq1 = MonHocDAO.updateMonHoc(v2);
            }
            if(kq1 == true){
                JOptionPane.showMessageDialog(null, " Thêm sv vào môn học thành công");
                //System.out.println("=============");
            }
            else{
                JOptionPane.showMessageDialog(null, " Thêm sv vào môn học thất bại");
            }
         }
//khi bấm nút change
         if(ev.getSource()==change){
             tenMon = JOptionPane.showInputDialog("Mời bạn nhập lại mã môn học");
             //kiem tra ma mon hop le
             v2 = null;
            v2 = MonHocDAO.layThongTinMonHoc(tenMon);
            listSvUpdate = null;
//             //neu co mon hoc
            if(v2 != null){
                j.setText(tenMon);
                j.setForeground(Color.green);
         
                if(v2.getMaSinhVien() == null || v2.getMaSinhVien().equals("")==true){
                     System.out.println("empty");
                }else{
                    //neu mon hoc co sinh vien roi
                    listSvUpdate =  v2.getMaSinhVien();
                    System.out.println(" ++=============++ list change: " + listSvUpdate);
                        
                    if(ds != null){
                       
                        MyTableModel model2 = new MyTableModel();
                        for(int i=0; i<ds.size(); i++){
                        SinhVien sv=ds.get(i);
                        //them sv vao table
                          model2.insertRow(new SinhVienStatus(sv.getMaSinhVien(), sv.getHoTen(), listSvUpdate.contains(sv.getMaSinhVien())));

                          System.out.println("========info=======");
                            System.out.println("Mã SV: " + sv.getMaSinhVien() + " boolean: " + listSvUpdate.contains(sv.getMaSinhVien()));
                            SvAccount c = sv.getIdsvaccount();
                        }
                        table = new JTable(model2);
                         table.setPreferredScrollableViewportSize(new Dimension(500, 150));
                        table.setFillsViewportHeight(true);
                        table.getModel().addTableModelListener(this);
                        //Create the scroll pane and add the table to it.
                       remove(scrollPane);
                        scrollPane = new JScrollPane(table);

                        //Add the scroll pane to this panel.
                        add(scrollPane);
                       }else{
                           System.out.println("error");
                       }
                }
//        
//                 //Create and set up the content pane.
//                 FormCheckSv newContentPane1 = new FormCheckSv();
//             //newContentPane.setOpaque(true); //content panes must be opaque
//             frame.add(newContentPane1);

            }else{
                JOptionPane.showMessageDialog(null, "Mã môn không hợp lệ bạn có thể thay đổi trong menu");
                j.setText("EMPTY! You must change the subject name in menu");
                j.setForeground(Color.red);
            }
         }
          if(ev.getSource()==exit){
              
                frame.setVisible(false);
          }
    }  
    
    public static void main(String[] args) {
       
        tenMon = JOptionPane.showInputDialog("Mời bạn nhập mã môn học");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(tenMon);
            }
        });
    }
}