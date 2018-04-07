/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateweek5;

import dao.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import pojo.*;

/**
 *
 * @author admin1
 */
public class HibernateWeek5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       List<SinhVien> ds = SinhVienDAO.layDanhSachSinhVien();
//       if(ds != null){
//        for(int i=0; i<ds.size(); i++){
//        SinhVien sv=ds.get(i);
//         System.out.println("========info=======");
//            System.out.println("Mã SV: " + sv.getMaSinhVien());
//           // System.out.println(sv.getSoSvAccount());
//            SvAccount c = sv.getIdsvaccount();
//            System.out.println("Tên: " + sv.getHoTen());
//            System.out.println("pass: " + c.getPassword());
//            System.out.println("name: " + c.getUsername());
//        }
//       }else{
//           System.out.println("error");
//       }

//    List<GiaoVu> ds1 =  GiaoVuDAO.layDanhSachGiaoVu();
//       if(ds1 != null){
//        for(int i=0; i<ds1.size(); i++){
//        GiaoVu gv = ds1.get(i);
//        String s = gv.getMaGiaoVu();
//         System.out.println("Mã GV: " + s);
//         System.out.println("========info=======");
//           
//            System.out.println("Tên: " + gv.getHoTen());
//            GvAccount c1 = gv.getIdgvaccount();
//           
//            System.out.println("pass: " + c1.getPassword());
//            System.out.println("name: " + c1.getUsername());
//        }
//       }else{
//           System.out.println("error");
//       }

//            SinhVien sv1=new SinhVien(); 
//            sv1.setMaSinhVien("3");
//            sv1.setHoTen("Tâm");
//            SvAccount cmnd =new SvAccount();
//            cmnd.setIdsvaccount("3");
//            cmnd.setUsername("3");
//            cmnd.setPassword("3");
//            
//           
//            sv1.setIdsvaccount(cmnd);
//            boolean kq1 =SinhVienDAO.themSinhVien(sv1);
//            if(kq1 == true){
//                System.out.println(" Thêm thành công");
//            }
//            else{
//                System.out.println("Thêm thất bại");
//            }

//            SinhVien sv1=new SinhVien(); 
//            sv1.setMaSinhVien("3");
//            sv1.setHoTen("Trần Văn Tâm");
//            SvAccount cmnd =new SvAccount();
//            cmnd.setIdsvaccount("3");
//            cmnd.setUsername("3");
//            cmnd.setPassword("3");
//            
//           
//            sv1.setIdsvaccount(cmnd);
//            boolean kq1 =SinhVienDAO.updateSinhVien(sv1);
//            if(kq1 == true){
//                System.out.println(" Sửa thành công");
//            }
//            else{
//                System.out.println("Sửa thất bại");
//            }


//        SinhVien v=null;
//        v=SinhVienDAO.layThongTinSinhVien("2");
//        if(v != null){
//            System.out.println("Sv số 2 pass: " + v.getIdsvaccount().getUsername());
//            System.out.println("Sv số 2 pass: " + v.getIdsvaccount().getPassword());
//            //Cmnd c = v.getSoCmnd();
//        }


//       List<MonHoc> ds = MonHocDAO.layDanhSachMonHoc();
//       if(ds != null){
//        for(int i=0; i<ds.size(); i++){
//        MonHoc mh = ds.get(i);
//         System.out.println("========info=======");
//            System.out.println("Mã môn: " + mh.getMaMonHoc());
//            System.out.println("Tên: " + mh.getTenMonHoc());
//            System.out.println("sv: " + mh.getMaSinhVien());
//            ThoiKhoaBieu c = mh.getThoiKhoaBieu();
//            
//            System.out.println("mã TKB: " + c.getMaTkb());
//            System.out.println("gio bd: " + c.getGioBatDau());
//             System.out.println("gio kt: " + c.getGioKetThuc());
//              System.out.println("ngay bd: " + c.getNgayBatDau());
//               System.out.println("ngay kt: " + c.getNgayKetThuc());
//            System.out.println("phong: " + c.getTenPhongHoc());
//            System.out.println("thứ: " + c.getThu());
//            System.out.println("duration: " + c.getKhoangThoiGian());
//        }
//       }else{
//           System.out.println("error");
//       }
       
       
//            SinhVien sv1=new SinhVien(); 
//            sv1.setMaSinhVien("3");
//            sv1.setHoTen("Trần Văn Tâm");
//            SvAccount cmnd =new SvAccount();
//            cmnd.setIdsvaccount("3");
//            cmnd.setUsername("3");
//            cmnd.setPassword("3");
//            sv1.setIdsvaccount(cmnd);
//            boolean kq1 =SinhVienDAO.updateSinhVien(sv1);
//            if(kq1 == true){
//                System.out.println(" Sửa thành công");
//            }
//            else{
//                System.out.println("Sửa thất bại");
//            }


////thêm và sửa mon hoc
//        MonHoc v=null;
//        v=MonHocDAO.layThongTinMonHoc("VL");
//        if(v != null){
//            System.out.println("môn:  " + v.getTenMonHoc());
//            System.out.println("phong: " + v.getThoiKhoaBieu().getTenPhongHoc());
//            //Cmnd c = v.getSoCmnd();
//        }
//        v.setMaSinhVien("1 2");
////            MonHoc sv1=new MonHoc(); 
////            sv1.setMaSinhVien("3");
////            sv1.setHoTen("Trần Văn Tâm");
////            SvAccount cmnd =new SvAccount();
////            cmnd.setIdsvaccount("3");
////            cmnd.setUsername("3");
////            cmnd.setPassword("3");
////            
////           
////            sv1.setIdsvaccount(cmnd);
//            boolean kq1 = MonHocDAO.updateMonHoc(v);
//            if(kq1 == true){
//                System.out.println(" Sửa thành công");
//            }
//            else{
//                System.out.println("Sửa thất bại");
//            }
            
//        Date date = new Date();
//        
//        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//        String strDate = formatter.format(date);
//        System.out.println("Date Format with MM/dd/yyyy: " + strDate);
//
//        formatter = new SimpleDateFormat("hh:mm");
//        strDate = formatter.format(date);
//        System.out.println("Date Format : " + strDate);

//       List<DiemDanh> ds = DiemDanhDAO.layDanhSachDiemDanh();
//       if(ds != null){
//        for(int i=0; i<ds.size(); i++){
//        DiemDanh sv=ds.get(i);
//         System.out.println("========info=======");
//            System.out.println("Mã: " + sv.getMaSinhVien());
////           
//            MonHoc c = sv.getMaMonHoc();
//            System.out.println("Tuần: " + sv.getTuan());
//            System.out.println("tên môn: " + c.getTenMonHoc());
//        }
//       }else{
//           System.out.println("error");
//       }

////    lấy ds điếm danh    
//    boolean kt = false;
//       List<DiemDanh> ds = DiemDanhDAO.layDanhSachDiemDanh("64", "CNTT");
//       if(ds.toString().equals("[]") == false){
//           System.out.println(ds.size());
//        for(int i=0; i<ds.size(); i++){
//        DiemDanh sv=ds.get(i);
//         System.out.println("========diem danh=======");
//            System.out.println("Mã: " + sv.getMaSinhVien());
//           
//            MonHoc c = sv.getMaMonHoc();
//            System.out.println("Tuần: " + sv.getTuan());
//            System.out.println("tên môn: " + c.getTenMonHoc());
//            
//            DiemDanhDAO.createArr(sv.getTuan());
//            kt = true;
//        }
//       }else{
//       //if(ds.toString().equals("[]") == true){
//           System.out.println("error");
//       }
//        //System.out.println(ds.toString());
//       if(kt == false){
//           System.out.println("error1");
//       }

// update
//    //thêm và sửa mon hoc
//        DiemDanh v=null;
//        v=DiemDanhDAO.layThongTinDiemDanh(4);
//        if(v != null){
//            System.out.println("môn:  " + v.getMaMonHoc().getTenMonHoc());
//            System.out.println("mã sv: " + v.getMaSinhVien());
//          
//        }
//        v.setTuan("1 5");
//            boolean kq1 = DiemDanhDAO.updateDiemDanh(v);
//            if(kq1 == true){
//                System.out.println(" Sửa thành công");
//            }
//            else{
//                System.out.println("Sửa thất bại");
//            }
//         //them bằng cách tự tăng id
//
//         MonHoc m = new MonHoc();
//         m = v.getMaMonHoc();
//
//         DiemDanh kt = DiemDanhDAO.addDiemDanh("2", m, "1");
//         if(kt != null){
//                System.out.println(" thêm thành công");
//            }
//            else{
//                System.out.println("thêm thất bại");
//            }
            
        Date date = new Date();
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy: " + strDate);
        
        //tính toán 1 tuần
        long  thoiGianMotTuan = 0L;
         formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date date1 = formatter.parse("04/01/2018");
            System.out.println("Date1: " + date1);
            Date date2 = formatter.parse("04/08/2018");
            System.out.println("Date2: " + date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        formatter = new SimpleDateFormat("hh:mm");
        strDate = formatter.format(date);
        System.out.println("Date Format : " + strDate);

         System.exit(1);
   }
    
}
