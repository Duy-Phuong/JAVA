/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbn2;

import dao.SinhVienDAO;
import java.util.Calendar;
import java.util.List;
import pojo.Cmnd;
import pojo.SinhVien;

/**
 *
 * @author admin1
 */
public class Hbn2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       List<SinhVien> ds = SinhVienDAO.layDanhSachSinhVien();
       if(ds != null){
        for(int i=0; i<ds.size(); i++){
        SinhVien sv=ds.get(i);
         System.out.println("========info=======");
            System.out.println("Mã SV: " + sv.getMaSinhVien());
           // System.out.println(sv.getSoCmnd());
            Cmnd c = sv.getSoCmnd();
           
            System.out.println("Ho tên: " + c.getHoTen());
            System.out.println("Ngày sinh: " + c.getNgaySinh());
        }
       }else{
           System.out.println("error");
       }
        
        System.out.println("lấy thông tin sv: ");
        SinhVien v=null;
        v=SinhVienDAO.layThongTinSinhVien("2");
        if(v != null){
            System.out.println("Sv số 2: " + v.getSoCmnd().getHoTen());
            //Cmnd c = v.getSoCmnd();
        }
        
        
//        SinhVien sv1=new SinhVien(); 
//        sv1.setMaSinhVien("9");
//            Cmnd cmnd=new Cmnd();
//            cmnd.setSoCmnd("6");
//            cmnd.setHoTen("Ta");
//            Calendar c=Calendar.getInstance();
//            c.set(1984, 6, 22);
//            cmnd.setNgaySinh(c.getTime());
//            c.set(2001, 4, 18);
//            sv1.setSoCmnd(cmnd);
//            boolean kq1 =SinhVienDAO.themSinhVien(sv1);
//            if(kq1 == true){
//                System.out.println(" Thêm thành công");
//            }
//            else{
//                System.out.println("Thêm thất bại");
//            }
         System.exit(1);
    }
   
}
