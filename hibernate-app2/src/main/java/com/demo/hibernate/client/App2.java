package com.demo.hibernate.client;

 

 

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

 

import com.demo.hibernate.Emp;

 

public class App2 {

 

    public static void main(String[] args) {
        
        Configuration cfg = new Configuration().configure();
        /*Configuration cfg = new Configuration()  Alternate method to map the class here instead of in hibernate cfg xml : comment the mapping class tag in hibernate cfg
        cfg.addAnnotatedClass(Emp.class);
        cfg.configure();*/
        
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            //Emp e1 = session.load(Emp.class, 107);
            //System.out.println(e1.getName() +" "+ e1.getSalary());
            Emp e1 = session.get(Emp.class, 1077); //get executes the query, load does not execute it   load returns the proxy object for non existent data also and will make the query on demand if you are doing operation on that object whereas get would return null on point. Load would never go to database
            System.out.println(e1.getClass().getName()); //at this line, load would make the query
        	
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
 