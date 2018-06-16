/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Checkin;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Admin
 */
public class CheckinDAO {

    private static Session ses;
    private static SessionFactory sesf;

    public static void addCheckin(Checkin checkin) {
        try {
            sesf = HibernateUtil.getSessionFactory();
            ses = sesf.openSession();
            ses.beginTransaction();
            ses.save(checkin);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
    }

    public static void updateCheckin(Checkin checkin) {
        try {
            sesf = HibernateUtil.getSessionFactory();
            ses = sesf.openSession();
            ses.beginTransaction();
            ses.update(checkin);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
    }

    public static void delCheckin(Checkin checkin) {
        try {
            sesf = HibernateUtil.getSessionFactory();
            ses = sesf.openSession();
            ses.beginTransaction();
            ses.delete(checkin);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
    }

    public static Checkin loadCheckin(int index) {
        Checkin checkin = null;
        try {
            sesf = HibernateUtil.getSessionFactory();
            ses = sesf.openSession();
            ses.beginTransaction();
            checkin = (Checkin) ses.load(Checkin.class, index);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
        return checkin;
    }

    public static ArrayList<Checkin> loadAllCheckin() {
        ArrayList<Checkin> listCheckin = null;
        try {
            sesf = HibernateUtil.getSessionFactory();
            ses = sesf.openSession();
            ses.beginTransaction();
            Query q = ses.createQuery("FROM Checkin ck JOIN FETCH ck.daibieu ORDER BY ck.ckId");
            listCheckin = (ArrayList<Checkin>) q.list();
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
        return listCheckin;
    }
}
