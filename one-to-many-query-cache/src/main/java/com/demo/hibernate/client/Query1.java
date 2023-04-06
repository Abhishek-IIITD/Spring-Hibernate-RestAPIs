package com.demo.hibernate.client;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class Query1 {
public static void main(String[] args) {

    
    Configuration cfg = new Configuration().configure();
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    
    try {
        Query<Emp> query = session.createQuery("select e from Emp e where e.empid between 107 and 112");
    	query.setCacheable(true);
    	query.setCacheRegion("SimpleQueries");
    	List<Emp> empList = query.getResultList();
    	empList.stream().forEach(e -> System.out.println(e.getEmpid()+" "+e.getEmpName()+" "+e.getSalary()));
    	
    	//sf.getCache().evictQueryRegion("SimpleQueries");
    	System.out.println("Pass 2....");
    	List<Emp> empList1 = query.getResultList();
    	empList1.stream().forEach(e -> System.out.println(e.getEmpid()+" "+e.getEmpName()+" "+e.getSalary()));
    	
    }
    catch(HibernateException e) {
        //tx.rollback();
        e.printStackTrace();
    }
    finally{
        session.close();
        sf.close();
    }

}
}
