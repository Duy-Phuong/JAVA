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
import pojo.MonHoc;
import util.HibernateUtil;

/**
 *
 * @author admin1
 */
public class MonHocDAO {
        public static List<MonHoc> layDanhSachMonHoc() {
    List<MonHoc> ds = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
    String hql = "select tkb from MonHoc tkb";
    Query query = session.createQuery(hql);
    ds = query.list();
    } catch (HibernateException ex) {
    System.err.println(ex);
    } finally {
    session.close();
    }
    return ds;
    }
    
    public static MonHoc layThongTinMonHoc(
        String maMonHoc) {
        MonHoc tkb = null;
        Session session = HibernateUtil.getSessionFactory().
        openSession();
        try {
        tkb =(MonHoc)session.get(MonHoc.class, maMonHoc);
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
        session.close();
        }
        return tkb;
    }
    
    public static boolean themMonHoc(MonHoc tkb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MonHocDAO.layThongTinMonHoc(tkb.getMaMonHoc()) != null) {
        return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.save(tkb);
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
    
    public static boolean updateMonHoc(MonHoc tkb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MonHocDAO.layThongTinMonHoc(tkb.getMaMonHoc()) == null) {
        return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.update(tkb);
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
