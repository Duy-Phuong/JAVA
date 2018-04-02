/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import pojo.*;

import java.util.Iterator;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import util.HibernateUtil;
public class SachDAO {
    public static Sach layThongTinSach(String maSach) {
        Sach sach = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        sach = (Sach) session.get(Sach.class, maSach);
         DanhMuc dm = sach.getDanhMuc();
        System.out.println(dm.getMaDanhMuc());
        System.out.println(dm.getTenDanhMuc());
        } catch (HibernateException ex) {
        //Log the exception
            System.err.println(ex);
        } finally {
        session.close();
        }
        return sach;
    }
    
    public static boolean themSach(Sach sach) {
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        if (SachDAO.layThongTinSach(sach.getMaSach()) != null) {
            return false;
        }
            boolean kq = true;
            Transaction transaction = null;
            try {
            transaction = session.beginTransaction();
            session.save(sach);
            transaction.commit();
            } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex); kq = false;
            } finally {session.close();}
            return kq;
        }
}
