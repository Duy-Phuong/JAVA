/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.DiemDanh;
import pojo.MonHoc;
import pojo.SinhVien;
import util.HibernateUtil;

/**
 *
 * @author admin1
 */
public class DiemDanhDAO {
 public static List<DiemDanh> layDanhSachDiemDanh(String maSV, String maMon) {
    List<DiemDanh> ds = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
    String hql = "select sv from DiemDanh sv where sv.maSinhVien = :maSV and sv.maMonHoc = :maMon";
    Query query = session.createQuery(hql);
    query.setString("maSV",maSV);
    query.setString("maMon",maMon);

    ds = query.list();
    } catch (HibernateException ex) {
    System.err.println(ex);
    } finally {
    session.close();
    }
    return ds;
    }
    
     public static List<DiemDanh> layDanhSachDiemDanh() {
    List<DiemDanh> ds = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
    String hql = "select sv from DiemDanh sv";
    Query query = session.createQuery(hql);
    //query.setString("maSinhVien",maSinhVien);

    ds = query.list();
    } catch (HibernateException ex) {
    System.err.println(ex);
    } finally {
    session.close();
    }
    return ds;
    }
    
    public static DiemDanh layThongTinDiemDanh(
        int maDiemDanh) {
        DiemDanh sv = null;
        Session session = HibernateUtil.getSessionFactory().
        openSession();
        try {
        sv =(DiemDanh)session.get(DiemDanh.class, maDiemDanh);
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
        session.close();
        }
        return sv;
    }
    
    public static boolean themDiemDanh(DiemDanh sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (DiemDanhDAO.layThongTinDiemDanh(sv.getId()) != null) {
        return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.save(sv);
        transaction.commit();
        } catch (HibernateException ex) {
        transaction.rollback();
        System.err.println(ex);
        kq = false;
        } finally {
        session.close();
        }
        return kq;
        }
     //them bằng cách tự tăng id
     public static DiemDanh addDiemDanh(String maSinhVien, MonHoc maMonHoc, String tuan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = null;
        DiemDanh ad = null;
        try {
            tx = session.beginTransaction();
            ad = new DiemDanh(maSinhVien, maMonHoc, tuan);
            id = (Integer) session.save(ad);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ad;
    }
    public static boolean updateDiemDanh(DiemDanh sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (DiemDanhDAO.layThongTinDiemDanh(sv.getId()) == null) {
        return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.update(sv);
        transaction.commit();
        } catch (HibernateException ex) {
        transaction.rollback();
        System.err.println(ex);
        kq = false;
        } finally {
        session.close();
        }
        return kq;
        }
    
    //lay tuan ma sv di hoc de return mang boolean de them vao table hien thi
    public static boolean[] createArr(String tuan) {
            boolean[] avaliable = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
            String[] s = tuan.split(" ");
            int[] num = new int[15];
            for (int i = 0; i < s.length; i++) {
             String str = s[i];
             if(str.equals("") == false){
                num[i] = Integer.parseInt(str);
             }
            
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0){
              //  System.out.println("num: " + num[i]);
                int j = num[i];
                avaliable[j-1] = true;
            }
            
        }
//        System.out.println("mang: ");   
//        for (int i = 0; i < num.length; i++) {
//            System.out.println("available" + i + ": " + avaliable[i]);
//           
//            
//        }
            return avaliable;
    }
}


