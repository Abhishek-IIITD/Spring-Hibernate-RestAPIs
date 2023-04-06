package com.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;
//@Component
@Service //readability increases
public class EmpService implements ApplicationContextAware{
	
	//@Autowired
	ApplicationContext ctx;
	
	@Autowired //can be pasted here
	@Qualifier("empDaoMockImpl2") //alternate to @Primary annotation
	private EmpDao dao; //if autowired is placed here, then setter is not reqd - it is recommended not to place autowired annotation above private variables
	
	//@Autowired  //here is good
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	public String registerEmp(int id, String name, String city, double sal) {
		System.out.println("Application Context "+ctx.getDisplayName());
		System.out.println(dao.getClass().getName());
		
		String response = dao.save(new Emp(id, name, city, sal));
		
		
		return response;
		
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx = applicationContext;
	}
}
