/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.KhoaHoc;
import util.HibernateUtil;

/**
 *
 * @author admin1
 */
public class KhoaHocDAO {
        public static KhoaHoc layThongTinKhoaHoc(String maKhoaHoc)
    {
        KhoaHoc sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        sv =(KhoaHoc) session.get(KhoaHoc.class, maKhoaHoc);
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
        session.close();
        }
        return sv;
    }
 
     public static boolean themKhoaHoc(KhoaHoc sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (KhoaHocDAO.layThongTinKhoaHoc(sv.getMaKhoaHoc()) != null) {
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
