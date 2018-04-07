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
import pojo.*;
import util.HibernateUtil;
/**
 *
 * @author admin1
 */
public class SinhVienDAO {
    public static SinhVien layThongTinSinhVien(String maSinhVien)
    {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        sv =(SinhVien) session.get(SinhVien.class, maSinhVien);
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
        session.close();
        }
        return sv;
    }
    //bo lazy vs join
    public static SinhVien layThongTinSinhVien2(String maSinhVien)
   { SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        try {
        String hql= " select sv ";
        hql +="from sinhvien sv left join fetch sv.khoahocs";
        hql += " where sv.maSinhVien=:maSinhVien";
        Query query = session.createQuery(hql);
        query.setString("maSinhVien", maSinhVien);
        sv = (SinhVien) query.uniqueResult();
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
        session.saveOrUpdate(sv);
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
