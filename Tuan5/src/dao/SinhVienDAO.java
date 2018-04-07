/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import pojo.SinhVien;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
/**
 *
 * @author admin1
 */
public class SinhVienDAO {
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
    
    public static SinhVien layThongTinSinhVien(
        String maSinhVien) {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().
        openSession();
        try {
        sv =(SinhVien)session.get(SinhVien.class, maSinhVien);
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
        session.close();
        }
        return sv;
    }
    
    public static boolean themSinhVien(SinhVien sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.layThongTinSinhVien(sv.getMaSinhVien()) != null) {
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
}
