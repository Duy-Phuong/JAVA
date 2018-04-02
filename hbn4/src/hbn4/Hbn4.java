/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbn4;

import dao.SinhVienDAO;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.KhoaHoc;
import pojo.SinhVien;
import util.HibernateUtil;

/**
 *
 * @author admin1
 */
public class Hbn4 {


    public static void main(String[] args) {
        System.out.println("SV 3: ");
       SinhVien sv=SinhVienDAO.layThongTinSinhVien("3");
        System.out.println(sv.getMaSinhVien());
        System.out.println(sv.getTenSinhVien());
        System.out.println(sv.getEmail());
        System.out.println(sv.getDiaChi());
        Iterator<KhoaHoc> khoaHocs=sv.getKhoahocs().iterator();
        while(khoaHocs.hasNext()){
            System.out.println("Khoa hoc: ");
        KhoaHoc kh=khoaHocs.next();
        System.out.print(kh.getMaKhoaHoc() + " -- ");
        System.out.println(kh.getTenKhoaHoc());
        }
        
        
        //them
        SinhVien sv1 = new SinhVien();
        sv1.setMaSinhVien("8");
        sv1.setTenSinhVien("Hoàng Minh Châu");
        sv1.setDiaChi("231 Phan Đăng Lưu Bình Thạnh");
        sv1.setEmail("hoangminh@gmail.com");
        KhoaHoc kh1 = new KhoaHoc();
        kh1.setMaKhoaHoc("4");
        kh1.setTenKhoaHoc(".NET");
        sv1.getKhoahocs().add(kh1);
         boolean kq1 =SinhVienDAO.themSinhVien(sv1);
            if(kq1 == true){
                System.out.println(" Thêm thành công");
            }
            else{
                System.out.println("Thêm thất bại");
            }
        
        System.exit(1);
    }
    
    
   
}
