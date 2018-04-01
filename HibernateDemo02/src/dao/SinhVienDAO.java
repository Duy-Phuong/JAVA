/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Iterator;
import pojo.SinhVien;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import util.HibernateUtil;

public class SinhVienDAO {
    public static List<SinhVien> layDanhSachSinhVien() {
    List<SinhVien> ds = null;
    Transaction tx = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
         tx=session.beginTransaction();
    String hql = "select sv from SinhVien sv";
    Query query = session.createQuery(hql);
    ds = query.list();
     tx.commit();
    }catch(HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
    } finally {
    session.close();
     StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
    }
    return ds;
    }
    
    public static SinhVien layThongTinSinhVien(String maSinhVien) {
        SinhVien sv = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
        sv = (SinhVien) session.get(SinhVien.class,
        maSinhVien);
        tx.commit();
        } catch (HibernateException ex) {
         if(tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
             StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        session.close();
        }
        return sv;
    }
    
    public static boolean themSinhVien(SinhVien sv) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            if (SinhVienDAO.layThongTinSinhVien(sv.getMaSinhVien())!= null) {
                System.out.println("Sv có rồi");
                System.out.println(sv.getMaSinhVien());
                return false;
            }
            Transaction tx = null;
            try {
            tx=session.beginTransaction();
            session.save(sv);
           
             List messages = session.createQuery("FROM SinhVien").list();
            for(Iterator iterator = messages.iterator(); iterator.hasNext();){
                SinhVien message = (SinhVien)iterator.next();
                System.out.println("==============================");
                System.out.println("getHoVaTen: "+message.getHoVaTen() );
                 System.out.println("getDiaChi: "+message.getDiaChi());
                 System.out.println("getMaSinhVien: "+message.getMaSinhVien());
                 System.out.println("ngay sinh: " + message.getNgaySinh());
                 
            }
             tx.commit();
            } catch (HibernateException ex) {
                if(tx != null) tx.rollback();
            ex.printStackTrace();
            } finally {
            
             StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
             session.close();
            }
            return true;
        }
    
    
    public static boolean capNhatThongTinSinhVien(SinhVien sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.layThongTinSinhVien(sv.getMaSinhVien()) == null) {
        return false;
        }
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.update(sv);
        transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
        transaction.rollback();
        System.err.println(ex);
        } finally {
        session.close();
        StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return true;
        }
    
    public static boolean xoaSinhVien(String maSinhVien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(maSinhVien);
        if(sv==null){
            
        return false;
        }
        Transaction transaction = null;
        try {
        transaction = session.beginTransaction();
        session.delete(sv);
        transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
        transaction.rollback();
        System.err.println(ex);
        } finally {
        session.close();
        StandardServiceRegistryBuilder.destroy(HibernateUtil.registry);
        }
        return true;
        }
}