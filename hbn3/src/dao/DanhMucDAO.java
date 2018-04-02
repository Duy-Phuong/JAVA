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
public class DanhMucDAO {
    public static DanhMuc layThongTinDanhmuc(String maDanhmuc) {
        DanhMuc dm = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        dm = (DanhMuc)session.get(DanhMuc.class, maDanhmuc);
        } catch (HibernateException ex) {
        System.err.println(ex);
        } finally {
        session.close();
        }
        return dm;
     }
}
