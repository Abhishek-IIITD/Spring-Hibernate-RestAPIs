package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class App1 {
public static void main(String[] args) {

    
    Configuration cfg = new Configuration().configure();
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    
    try {
        Dept dept = session.load(Dept.class, 20);
        Emp e1 = new Emp(114, "Ratan", "Ranchi", 56000);
        Emp e2 = new Emp(115, "Rajesh", "Bangalore", 66000);
        dept.getEmps().add(e1);
        dept.getEmps().add(e2);
         
        session.update(dept); // don't do execution from dept side as Entity A is the owner of the relation. If you do from dept side, then for 1 insert, 1 update query is added. If you want 10000 queries to be executed, it will execute 20000 queries which is not desirable
        tx.commit();
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
