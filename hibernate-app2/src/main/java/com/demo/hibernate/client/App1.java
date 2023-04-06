package com.demo.hibernate.client;

 

 

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

 

import com.demo.hibernate.Emp;

 

public class App1 {

 

    public static void main(String[] args) {
        
        Configuration cfg = new Configuration().configure();
        /*Configuration cfg = new Configuration()  Alternate method to map the class here instead of in hibernate cfg xml : comment the mapping class tag in hibernate cfg
        cfg.addAnnotatedClass(Emp.class);
        cfg.configure();*/
        
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            Emp emp = new Emp(107, "Rajat", "Delhi", 45000);
            session.persist(emp); // It saves in session cache
            tx.commit();// It commit the changes in database
        }
        catch(HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
            sf.close();
        }
    }

 

}
 