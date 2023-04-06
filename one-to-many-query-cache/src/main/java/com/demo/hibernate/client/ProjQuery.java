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

public class ProjQuery {
public static void main(String[] args) {

    
    Configuration cfg = new Configuration().configure();
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    
    try {
        //Query<Object[]> query = session.createQuery("select e.empName, e.salary from Emp e where e.empid between 107 and 112");
    	Query<Emp> query = session.createQuery("select new Emp(e.empName, e.salary) from Emp e where e.empid between 107 and 112");
    	
    	/*List<Object[]> empList = query.getResultList();
    	for(Object[] obj : empList) {
    		String name = (String)obj[0];
    		Double sal = (Double)obj[1];
    		System.out.println(name+" "+sal);
    	}*/
    	List<Emp> empList = query.getResultList();
    	for(Emp e : empList) {
    		
    		System.out.println(e.getEmpName()+" "+e.getSalary());
    	}
    	
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
