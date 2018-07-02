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

public class FormKQDiemDanhSV extends JPanel implements TableModelListener,ActionListener  {
    private boolean DEBUG = false;
    JTable table;
    static JButton j;
    static List<SinhVien> ds = null;
    static String tenMon = "";
    static MyTableModel model;
    static String listSvUpdate = ""; // danh sách sv sau khi tick
    static JMenu file = new JMenu("File");
    static JMenuItem change = new JMenuItem("Change subject name");
    static JMenuItem exit = new JMenuItem("Exit");
    JScrollPane scrollPane;
   
    static MonHoc v2 = null;
    static  JFrame frame;
    static FormKQDiemDanhSV newContentPane;
    static String maSV;
    String[] dsTuan = {"tuan 1", "tuan 2", "tuan 3", "tuan 4", "tuan 5", "tuan 6", "tuan 7", "tuan 8", "tuan 9", "tuan 10", "tuan 11", "tuan 12", "tuan 13", "tuan 14", "tuan 15"};
    String[] dsTinhTrang = {"vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng", "vắng"};
    public FormKQDiemDanhSV() {
        super(new GridLayout(1,0)); //khi kéo nó k bị giãn

         change.addActionListener(this); 
         exit.addActionListener(this); 
        model = new MyTableModel();
        //
        v2 = MonHocDAO.layThongTinMonHoc(tenMon);
        if(v2 != null){
            //neu SV ta đnag xét đang nằm trong
            if(v2.getMaSinhVien().contains(maSV) == true){
                //kiem tra ma mon hop le
                List<DiemDanh> v=null;
                v=DiemDanhDAO.layDanhSachDiemDanh(maSV, tenMon);

                //neu co mon hoc
                if(v.toString().equals("[]") == false){

                    for (int i = 0; i < v.size(); i++) {
                        if(v.get(i) != null){
                            listSvUpdate = v.get(i).getTuan();// lấy ra những tuần đi học của sinh viên đó
                        }

                    }
                }
             
                for(int i=0; i<dsTuan.length; i++){
                  //nếu danh sách tuần đi học của sinh viên đó có thì thay status
                  if(listSvUpdate.contains(String.valueOf(i+1)) == true){
                        model.insertRow(new DiemDanhTuan(dsTuan[i], "có mặt"));
                  }else{
                         model.insertRow(new DiemDanhTuan(dsTuan[i], dsTinhTrang[i]));
                  }
                }
            }else{
                
                for(int i=0; i<dsTuan.length; i++){
                    model.insertRow(new DiemDanhTuan(dsTuan[i], dsTinhTrang[i]));
                }

                
                JOptionPane.showMessageDialog(null, "SV chưa đăng kí học môn đó");
            }
        }else{
            System.out.println("Mon hoc khong ton tai");
        }

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

    }
    
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {
        "Tuần", "Tình trạng"};
       
        Vector data = new Vector(10000);

        
        /* ADDED MORE */
        public void insertRow(DiemDanhTuan c)
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
            DiemDanhTuan c = (DiemDanhTuan)data.get(row);
            
            switch(col) {
                case 0:
                    return c.getMaTuan();
                case 1:
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
        frame = new JFrame("Xem kết qua điểm danh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
      
        //Display the window.
        frame.pack();
        frame.setVisible(true);
     
        frame.setSize(400,400);  
        frame.setLocationRelativeTo(null);
        
        

          
            file.add(change);
             file.add(exit);
            JMenuBar mb = new JMenuBar();
            mb.add(file);
            frame.add(mb);
            frame.setLayout(new BorderLayout());  
             
              //Create and set up the content pane.
        newContentPane = new FormKQDiemDanhSV();
        //newContentPane.setOpaque(true); //content panes must be opaque
        frame.add(newContentPane);
//       
        frame.add(mb,BorderLayout.NORTH);  

        j = new JButton(tenMon);
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
        
//khi bấm nút change
         if(ev.getSource()==change){
              MyTableModel model2 = new MyTableModel();
             tenMon = JOptionPane.showInputDialog("Mời bạn nhập lại mã môn học");
             //kiem tra ma mon hop le
            v2 = null;
            v2 = MonHocDAO.layThongTinMonHoc(tenMon);
            listSvUpdate = null;
  //neu co mon hoc
            if(v2 != null){
                j.setText(tenMon.toUpperCase());
                j.setForeground(Color.green);
                //neu SV ta đnag xét đang nằm trong
            if(v2.getMaSinhVien().contains(maSV) == true){    
                List<DiemDanh> v=null;

                v=DiemDanhDAO.layDanhSachDiemDanh(maSV, tenMon);

                //neu co mon hoc
                if(v.toString().equals("[]") == false){

                    for (int i = 0; i < v.size(); i++) {
                        if(v.get(i) != null){
                            listSvUpdate = v.get(i).getTuan();// lấy ra những tuần đi học của sinh viên đó
                        }

                    }
                }
                       
                         if(dsTuan != null){
                             for(int i=0; i<dsTuan.length; i++){
                               //nếu danh sách tuần đi học của sinh viên đó có thì thay status
                               if(listSvUpdate.contains(String.valueOf(i+1)) == true){
                                     model2.insertRow(new DiemDanhTuan(dsTuan[i], "có mặt"));
                               }else{
                                      model2.insertRow(new DiemDanhTuan(dsTuan[i], dsTinhTrang[i]));
                               }
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
                
                }else{
                       for(int i=0; i<dsTuan.length; i++){
                                      model2.insertRow(new DiemDanhTuan(dsTuan[i], dsTinhTrang[i]));
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
                    JOptionPane.showMessageDialog(null, "SV chưa đăng kí học môn đó");
                }

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
       
        tenMon = FormSinhVien1.maMon0;
        maSV = FormSinhVien1.maSinhVien0;
        //tenMon = "cntt";
        //maSV = "4";
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(tenMon);
            }
        });
    }
}