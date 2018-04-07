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
import pojo.GiaoVu;
import util.HibernateUtil;

/**
 *
 * @author admin1
 */
public class GiaoVuDAO {
     public static List<GiaoVu> layDanhSachGiaoVu() {
    List<GiaoVu> ds = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
    String hql = "select gv from GiaoVu gv";
    Query query = session.createQuery(hql);
    ds = query.list();
    } catch (HibernateException ex) {
    System.err.println(ex);
    } finally {
    session.close();
    }
    return ds;
    }
    
    public static GiaoVu layThongTinGiaoVu(
        String maGiaoVu) {
        GiaoVu gv = null;
        Session session = HibernateUtil.getSessionFactory().
        openSession();
        try {
        gv =(GiaoVu)session.get(GiaoVu.class, maGiaoVu);
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
        session.close();
        }
        return gv;
    }
    
    public static boolean themGiaoVu(GiaoVu gv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (GiaoVuDAO.layThongTinGiaoVu(gv.getMaGiaoVu()) != null) {
        return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.save(gv);
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
