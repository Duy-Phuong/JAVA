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
import pojo.SinhVien;
import util.HibernateUtil;

/**
 *
 * @author admin1
 */
public class DiemDanhDAO {
    public static List<SinhVien> layDanhSachSinhVien() {
    List<SinhVien> ds = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
    String hql = "select sv from SinhVien sv";
    Query query = session.createQuery(hql);
    ds = query.list();
    } catch (HibernateException ex) {
    System.err.println(ex);
    } finally {
    session.close();
    }
    return ds;
    }
    
//     public static List<DiemDanh> layDanhSachDiemDanh() {
//    List<DiemDanh> ds = null;
//    Session session = HibernateUtil.getSessionFactory().openSession();
//    try {
//    String hql = "select sv from diemdanh sv";
//    Query query = session.createQuery(hql);
//    //query.setString("maSinhVien",maSinhVien);
//
//    ds = query.list();
//    } catch (HibernateException ex) {
//    System.err.println(ex);
//    } finally {
//    session.close();
//    }
//    return ds;
//    }
    
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
}


