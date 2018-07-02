/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateweek5;

import javax.swing.event.*;

import dao.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import pojo.*;

public class FormDiemDanh extends JPanel implements TableModelListener,ActionListener  {
     private boolean DEBUG = false;
    JTable table;
    static JButton j;
    static List<SinhVien> ds = null;
    static List<SinhVien> dsTable = new ArrayList<SinhVien>();
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
    static FormDiemDanh newContentPane;
     int[] num = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    boolean[] avaliable = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
   
    
    public FormDiemDanh() {
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
                listSv =  v.getMaSinhVien();//lay ra ds sv dk mon do
                //System.out.println("list: " + listSv);
                 listSvUpdate = listSv; // khoi tao cho no nhung sv co roi    

            }
        }
        //them ds sv tu bang sv
       ds = SinhVienDAO.layDanhSachSinhVien();
       if(ds != null){
        for(int i=0; i<ds.size(); i++){
        SinhVien sv=ds.get(i);
        //sinh vien do nam trong mon hoc moi hien thi de diem danh
        if(listSvUpdate.contains(sv.getMaSinhVien()) == true){
           dsTable.add(sv);
            boolean[] k = null; 
            //lay ra ds sinh vien trong bang dienm danh co tuần đi học khi có ma sv và mã môn
        List<DiemDanh> ds3 = DiemDanhDAO.layDanhSachDiemDanh(sv.getMaSinhVien(), tenMon);
       if(ds3.toString().equals("[]") == false){
          // System.out.println(ds.size());
        for(int i3=0; i3<ds3.size(); i3++){
         DiemDanh sv3=ds3.get(i3);
         System.out.println("========diem danh=======");
            System.out.println("Mã: " + sv3.getMaSinhVien());
           System.out.println("Tuần: " + sv3.getTuan());
           
            MonHoc c3 = sv3.getMaMonHoc();
            System.out.println("tên môn: " + c3.getTenMonHoc());
            //tao ra mang boolean để có thể set vào table
           k = DiemDanhDAO.createArr(sv3.getTuan());
           
        }
       }else{
            k = avaliable; // nếu k có đi học tuần nào thì cho gán k bằng mảng false
           System.out.println("error");
       }
        //them sv vao table
          model.insertRow(new SinhVienDiemDanh(sv.getMaSinhVien(), sv.getHoTen(), k));
        }
          System.out.println("========info=======");
            System.out.println("Mã SV: " + sv.getMaSinhVien());
            //SvAccount c = sv.getIdsvaccount();
        }

       }else{
           System.out.println("error");
       }
        
        
         
     
        
         table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);
        
        //
        table.setCellSelectionEnabled(true);  
            ListSelectionModel select= table.getSelectionModel();  
            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
            select.addListSelectionListener(new ListSelectionListener() {  
              public void valueChanged(ListSelectionEvent e) {  
                boolean Data = false;  
                int[] row = table.getSelectedRows();  
                int[] columns = table.getSelectedColumns();  
                for (int i = 0; i < row.length; i++) {  
                  for (int j = 0; j < columns.length; j++) {  
                    Data = (boolean) table.getValueAt(row[i], columns[j]);  
                  } }  
                System.out.print("Row: ");
        int a = table.getSelectedRow();
        int b = table.getSelectedColumn();
        System.out.print(a);
        System.out.print(" - Colum: ");
        System.out.print(b);
        System.out.print(" - Value: ");
        System.out.print(Data);
        
         System.out.print(" - tuần: ");
        System.out.println(num[b]);
                System.out.println("Table element selected is: " + Data);   
                
              }       
            });  
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
        
        //Add the scroll pane to this panel.
        add(scrollPane);
        
    }
//khi check
    public void tableChanged(TableModelEvent e) {
//        System.out.print("Row: ");
//        int a = table.getSelectedRow();
//        int b = table.getSelectedColumn();
//        System.out.print(a);
//        System.out.print(" - Colum: ");
//        System.out.print(b);
//        System.out.print(" - Value: ");
//        System.out.print(table.getValueAt(a, 2));
//        
//         System.out.print(" - tuần: ");
//        System.out.println(num[b]);
//        if((boolean)table.getValueAt(a, b) == true){
//            listSvUpdate = listSvUpdate + " " + table.getValueAt(a, 0);
//        }else{
//            String find = (String)table.getValueAt(a, 0);
//            if(listSvUpdate.contains((String)table.getValueAt(a, 0))){
//            StringBuffer buff = new StringBuffer(listSvUpdate);
//            buff.delete(listSvUpdate.indexOf(find), listSvUpdate.indexOf(find) + 2);
//            listSvUpdate = buff.toString().trim();
//            }
//             if(listSvUpdate.contains((String)table.getValueAt(a, 0))){
//            //tim lai 1 lan nua neu co
//            StringBuffer buff1 = new StringBuffer(listSvUpdate);
//            buff1.delete(listSvUpdate.indexOf(find), listSvUpdate.indexOf(find) + 2);
//            listSvUpdate = buff1.toString().trim();
//             }
//        }
//        System.out.println("list update: " + listSvUpdate);
    }
    
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Mã SV",
        "Họ và tên",
        "tuần 1", "tuần 2", "tuần 3", "tuần 4","tuần 5","tuần 6","tuần 7", "tuần 8", "tuần 9",
        "tuần 10","tuần 11", "tuần 12", "tuần 13", "tuần 14", "tuần 15", };
       
        Vector data = new Vector(10000);

        
        /* ADDED MORE */
        public void insertRow(SinhVienDiemDanh c)
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
            SinhVienDiemDanh c = (SinhVienDiemDanh)data.get(row);
            
            switch(col) {
                case 0:
                    return c.getMaSinhVien();
                case 1:
                    return c.getTenSinhVien();
                case 2:
                    return c.isAvaliable(0);
                case 3:
                    return c.isAvaliable( 1);
                   
                case 4:
                   return c.isAvaliable(2);
                   
                case 5:
                    return c.isAvaliable(3);
                    
                case 6:
                    return c.isAvaliable(4);
                   
                case 7:
                    return c.isAvaliable(5);
                   
                case 8:
                  return c.isAvaliable( 6);
                   
                case 9:
                    return c.isAvaliable(7);
                   
                case 10:
                  return c.isAvaliable(8);
                   
                case 11:
                    return c.isAvaliable(9);
                   
                case 12:
                    return c.isAvaliable(10);
                   
                case 13:
                   return c.isAvaliable(11);
                    
                case 14:
                    return c.isAvaliable(12);
                   
                case 15:
                    return c.isAvaliable(13);
                   
                case 16:
                   return c.isAvaliable(14);
                   
                case 17:
                    return c.isAvaliable(15);
                   
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
            SinhVienDiemDanh c = (SinhVienDiemDanh)data.get(row);
            switch(col) {
                case 0:
                    c.setMaSinhVien((String)value);
                    break;
                case 1:
                    c.setTenSinhVien((String)value);
                    break;
                case 2:
                    c.setAvaliable((Boolean)value, 0);
                    break;
                case 3:
                    c.setAvaliable((Boolean)value, 1);
                    break;
                case 4:
                   c.setAvaliable((Boolean)value, 2);
                    break;
                case 5:
                    c.setAvaliable((Boolean)value, 3);
                    break;
                case 6:
                    c.setAvaliable((Boolean)value, 4);
                    break;
                case 7:
                    c.setAvaliable((Boolean)value, 5);
                    break;
                case 8:
                   c.setAvaliable((Boolean)value, 6);
                    break;
                case 9:
                    c.setAvaliable((Boolean)value, 7);
                    break;
                case 10:
                  c.setAvaliable((Boolean)value, 8);
                    break;
                case 11:
                    c.setAvaliable((Boolean)value, 9);
                    break;
                case 12:
                    c.setAvaliable((Boolean)value, 10);
                    break;
                case 13:
                   c.setAvaliable((Boolean)value, 11);
                    break;
                case 14:
                    c.setAvaliable((Boolean)value, 12);
                    break;
                case 15:
                    c.setAvaliable((Boolean)value, 13);
                    break;
                case 16:
                    c.setAvaliable((Boolean)value, 14);
                    break;
                case 17:
                    c.setAvaliable((Boolean)value, 15);
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
     
        frame.setSize(1100,600);  
        frame.setLocationRelativeTo(null);
        
        

            file.add(add);
            file.add(change);
             file.add(exit);
            JMenuBar mb = new JMenuBar();
            mb.add(file);
            frame.add(mb);
            frame.setLayout(new BorderLayout());  
             
              //Create and set up the content pane.
        newContentPane = new FormDiemDanh();
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
             String tuan = "";
           if(dsTable != null){
               for (int i = 0; i < dsTable.size(); i++) {
                  // System.out.println("sv: " + dsTable.get(i).getMaSinhVien());
                  tuan = ""; //sau mỗi hàng
                   for (int k = 2; k < 17; k++) {
                       if((boolean)table.getValueAt(i, k) == true){
                           tuan = tuan.trim() + " " + String.valueOf(num[k]);

                       }
                       
                   }
                   System.out.println("tuan: " + tuan);
                   //lay ra tuan di hoc cua sv i
                          List<DiemDanh> ds3 = DiemDanhDAO.layDanhSachDiemDanh(dsTable.get(i).getMaSinhVien(), tenMon);
                            if(ds3.toString().equals("[]") == false){
                               // System.out.println(ds.size());
                             for(int i3=0; i3<ds3.size(); i3++){
                              DiemDanh sv3=ds3.get(i3);
                                System.out.println("========diem danh add=======");
                                 System.out.println("Mã: " + sv3.getMaSinhVien());
                                System.out.println("Tuần: " + sv3.getTuan());
                                 sv3.setTuan(tuan.trim());
//                                 MonHoc c3 = sv3.getMaMonHoc();
//                                 System.out.println("tên môn: " + c3.getTenMonHoc());
                                boolean kq1 = DiemDanhDAO.updateDiemDanh(sv3);
                                if(kq1 == true){
                                    System.out.println(" Sửa thành công diem danh");
                                }
                                else{
                                    System.out.println("sửa lỗi");
                                }
                               

                             }
                            }else{
                                //add vao neu chưa tồn tại trong csdl va tư tăng id *****
                                v2.setMaMonHoc(tenMon.toUpperCase());
                            DiemDanh ktq = DiemDanhDAO.addDiemDanh(dsTable.get(i).getMaSinhVien(), v2, tuan);
                            if(ktq != null){
                                   System.out.println(" thêm thành công");
                                  // JOptionPane.showMessageDialog(null, "Thêm thành công");
                               }
                               else{
                                   System.out.println("thêm thất bại");
                                  //  JOptionPane.showMessageDialog(null, "Thêm thất bại");
                               }
                            }
                   
               }
           }


         }
//khi bấm nút change
         if(ev.getSource()==change){
             tenMon = JOptionPane.showInputDialog("Mời bạn nhập lại mã môn học");
             //kiem tra ma mon hop le
             v2 = null;
            v2 = MonHocDAO.layThongTinMonHoc(tenMon);
            listSvUpdate = null;
            //tao 1 ds mới
            dsTable.clear();
                    
             //neu co mon hoc
            if(v2 != null){
                j.setText(tenMon.toUpperCase());
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
                        if(listSvUpdate.contains(sv.getMaSinhVien()) == true){
                            dsTable.add(sv);
    boolean[] k = null; 
            //lay ra ds sinh vien trong bang dienm danh co tuần đi học
        List<DiemDanh> ds3 = DiemDanhDAO.layDanhSachDiemDanh(sv.getMaSinhVien(), tenMon);
       if(ds3.toString().equals("[]") == false){
           System.out.println(ds.size());
        for(int i3=0; i3<ds3.size(); i3++){
         DiemDanh sv3=ds3.get(i3);
         System.out.println("========diem danh=======");
            System.out.println("Mã: " + sv3.getMaSinhVien());
           
            MonHoc c3 = sv3.getMaMonHoc();
            System.out.println("Tuần: " + sv3.getTuan());
            System.out.println("tên môn: " + c3.getTenMonHoc());
            
           k = DiemDanhDAO.createArr(sv3.getTuan());
           
        }
       }else{
            k = avaliable;
           System.out.println("error");
       }
           
                          model2.insertRow(new SinhVienDiemDanh(sv.getMaSinhVien(), sv.getHoTen(), k));
                        }
                       //   System.out.println("========info=======");
                       //     System.out.println("Mã SV: " + sv.getMaSinhVien() + " boolean: " + listSvUpdate.contains(sv.getMaSinhVien()));
                        //    SvAccount c = sv.getIdsvaccount();
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
         tenMon = tenMon.toUpperCase();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(tenMon);
            }
        });
    }
}