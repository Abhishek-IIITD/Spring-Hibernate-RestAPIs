package com.demo.hibernate.client;

 

 

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Employee;
import com.demo.hibernate.Person;
import com.demo.hibernate.TraineeEmp;

 

public class App2 {

 

    public static void main(String[] args) {
        
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        try {
        	TraineeEmp t1 = session.get(TraineeEmp.class, 7);
        	System.out.println(t1.getName()+" "+t1.getPerformance()+" "+t1.getSalary());
        	
        	Person p1 = session.get(Person.class, 7);
        	System.out.println(p1.getName()+" "+p1.getId());
        	
        	//tx.commit();// It commit the changes in database
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
 