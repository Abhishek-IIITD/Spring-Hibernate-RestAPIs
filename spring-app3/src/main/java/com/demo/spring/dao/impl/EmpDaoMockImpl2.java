package com.demo.spring.dao.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

//@Component
@Repository   //means data layer class which is handling data - readability increases. Repository is itself a component
//@Primary //If two implementations are there
public class EmpDaoMockImpl2 implements EmpDao{

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return "Mock2: Emp saved with id "+e.getEmpid();
	}

}
