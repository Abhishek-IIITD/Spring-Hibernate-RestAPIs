package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpDaoHibImpl;
import com.demo.spring.entity.Emp;

public class SpringHibMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HibAppConfig.class);//all beans have instantiated
		EmpDao empDao = (EmpDao) ctx.getBean("empDaoHibImpl");
		System.out.println(empDao.getClass().getName()); //proxy is printed if Transaction is applied
		empDao.save(new Emp(402, "Nandi", "Bangalore", 65000));
		
	}

}
