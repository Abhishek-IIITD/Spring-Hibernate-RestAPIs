package com.demo.spring.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

//@Component
@Repository   //means data layer class which is handling data - readability increases. Repository is itself a component
public class EmpDaoMockImpl implements EmpDao{

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return "Mock: Emp saved with id "+e.getEmpid();
	}

}
