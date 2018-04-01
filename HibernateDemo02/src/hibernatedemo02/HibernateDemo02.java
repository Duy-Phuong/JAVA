/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo02;
import java.util.List;
import pojo.SinhVien;
import dao.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.HibernateUtil;
/**
 *
 * @author admin1
 */
public class HibernateDemo02 {



    public static void main(String[] args) {
       
        //<editor-fold defaultstate="collapsed" desc="1. Lấy danh sách sinh viên">

//        
//        //Lấy thông tin SV a
//        //<editor-fold defaultstate="collapsed" desc="2. Lấy thông tin sinh viên">
//        SinhVien sv = SinhVienDAO.layThongTinSinhVien("2");
//        System.out.println("========Thong tin SV có ma là 2 =========");
//        if(sv!=null){
//        System.out.println("MSSV: " + sv.getMaSinhVien());
//        System.out.println("Họ và tên: " +
//        sv.getHoVaTen());
//        System.out.println("Ngày sinh: " +
//        sv.getNgaySinh());
//        System.out.println("Địa chỉ: " + sv.getDiaChi());
//        }else{
//        System.out.println("Sinh viên 0312143 không tồn tại");
//        }
//            
//        //<editor-fold defaultstate="collapsed" desc="3. Thêm  sinh viên">
//                SinhVien sv1 = new SinhVien();
//                sv1.setMaSinhVien("5");
//                sv1.setHoVaTen("Tạ Tấn Thêm");
//                Calendar calendar = Calendar.getInstance();
//                calendar.set(1985, 5, 18);
//                Date d = new Date(calendar.getTimeInMillis());
//                sv1.setNgaySinh(d);
//                sv1.setDiaChi("Vĩnh Long");
//                boolean kq = SinhVienDAO.themSinhVien(sv1);
//                if (kq == true) {
//                System.out.println("Thêm thành công");
//                } else {
//                System.out.println("Thêm thất bại");
//                }
                
        //<editor-fold defaultstate="collapsed" desc="4. Cập nhật sinh viên">
//            SinhVien sv2 = SinhVienDAO.layThongTinSinhVien("5");
//            if (sv2 != null) {
//            sv2.setHoVaTen("Tạ Tấn");
//            Calendar calendar2 = Calendar.getInstance();
//                calendar2.set(1985, 5, 18);
//                Date d2 = new Date(calendar2.getTimeInMillis());
//                sv2.setNgaySinh(d2);
//            sv2.setDiaChi("Vũng Liêm – Vĩnh Long");
//            boolean kq2 = SinhVienDAO.capNhatThongTinSinhVien(sv2);
//            if (kq2 == true) {
//            System.out.println("Cập nhật thành công");
//            } else {
//            System.out.println("Cập nhật thất bại");
//            }
//            }
//                
                        //<editor-fold defaultstate="collapsed" desc="5. Xóa sinh viên">
            boolean kq = SinhVienDAO.xoaSinhVien("5");
            if (kq == true) {
            System.out.println("Xóa thành công");
            } else {
            System.out.println("Xóa thất bại");
            }
            
            //in
              List<SinhVien> ds1 = SinhVienDAO.layDanhSachSinhVien();
        if(ds1 == null){
            System.out.println("error");
        }else {
            for(int i=0; i< ds1.size(); i++){
            SinhVien sv3=ds1.get(i);
            System.out.println("MSSV: "+sv3.getMaSinhVien());
            System.out.println("Họ và tên: "+ sv3.getHoVaTen());
            System.out.println("Ngày sinh: " + sv3.getNgaySinh());
            System.out.println("Địa chỉ: "+ sv3.getDiaChi());
            }
        }
                
                
//try{
//            Configuration conf = new Configuration().configure();
//            registry = new StandardServiceRegistryBuilder().applySettings(
//            conf.getProperties()).build();
//            factory = conf.buildSessionFactory(registry);
//        } catch (Throwable ex){
//            System.err.println("Failed to create session factory object"+ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//        Session session = factory.openSession();
//        Transaction tx = null;
//       
//        try{
//            tx=session.beginTransaction();
//            
//            List messages = session.createQuery("FROM SinhVien").list();
//            for(Iterator iterator = messages.iterator(); iterator.hasNext();){
//                SinhVien message = (SinhVien)iterator.next();
//                System.out.println("==============================");
//                System.out.println("getHoVaTen: "+message.getHoVaTen() );
//                 System.out.println("getDiaChi: "+message.getDiaChi());
//                 System.out.println("getMaSinhVien: "+message.getMaSinhVien());
//                 System.out.println("ngay sinh: " + message.getNgaySinh());
//                 
//            }
//            tx.commit();
//        }catch(HibernateException e){
//            if(tx != null) tx.rollback();
//            e.printStackTrace();
//        }finally{
//            session.close();
//        }
//    StandardServiceRegistryBuilder.destroy(registry);
//    }
//    
}
}

