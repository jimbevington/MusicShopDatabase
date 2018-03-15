package db;

import models.Guitar;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

//    public static List<Guitar> getAll(Class<Guitar> guitarClass) {
//    }

    public static <T> List<T> getList(Criteria cr){
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = cr.list();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
