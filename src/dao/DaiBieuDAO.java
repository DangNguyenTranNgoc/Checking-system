/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Daibieu;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Admin
 */
public class DaiBieuDAO {

    private static Session ses;

    public static void addDaiBieu(Daibieu daibieu) {
        try {
            ses = HibernateUtil.openSession();
            ses.beginTransaction();
            ses.save(daibieu);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
    }

    public static void updateDaiBieu(Daibieu daibieu) {
        try {
            ses = HibernateUtil.openSession();
            ses.beginTransaction();
            ses.update(daibieu);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
    }

    public static void delDaiBieu(Daibieu daibieu) {
        try {
            ses = HibernateUtil.openSession();
            ses.beginTransaction();
            ses.delete(daibieu);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
    }

    public static Daibieu loadDaiBieu(int index) {
        Daibieu daibieu = null;
        try {
            ses = HibernateUtil.openSession();
            ses.beginTransaction();
            daibieu = (Daibieu) ses.load(Daibieu.class, index);
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
        return daibieu;
    }

    public static ArrayList<Daibieu> loadAllDaiBieu() {
        ArrayList<Daibieu> listDaiBieu = null;
        try {
            ses = HibernateUtil.openSession();
            ses.beginTransaction();
            Query q = ses.createQuery("FROM Daibieu");
            listDaiBieu = (ArrayList<Daibieu>) q.list();
            ses.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ses.getTransaction().rollback();
        } finally {
            ses.close();
        }
        return listDaiBieu;
    }
}
