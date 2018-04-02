/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbn1;

import dao.SachDAO;
import pojo.*;

/**
 *
 * @author admin1
 */
public class Hbn1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      Sach sach = SachDAO.layThongTinSach("S001");
//        if (sach != null) {
//        DanhMuc dm = sach.getDanhMuc();
//        System.out.println(dm.getMaDanhMuc());
//        System.out.println(dm.getTenDanhMuc());
//        }


    //demo2 nếu cascade = none thì nếu mã DM chưa có thì k thêm dk
    Sach sach=new Sach();
    sach.setMaSach("S027");
    sach.setTenSach("Hibernate 3");
    sach.setGiaBan(20000d);
    sach.setSoLuong(1000);
    sach.setHinhAnh("images/hibernate3.jpg");
    sach.setTacGia("Nguyễn Hoàng Anh");
    DanhMuc dm = new DanhMuc("DM013", "Java2");
    sach.setDanhMuc(dm);
    boolean kq=SachDAO.themSach(sach);
    if(kq == true){
        System.out.println(" Thêm thành công");
    }
    else{
        System.out.println("Thêm thất bại");
    }
    System.exit(1);
    }
    
}
