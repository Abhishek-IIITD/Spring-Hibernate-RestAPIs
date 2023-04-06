package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpDaoJdbcImpl;
import com.demo.spring.entity.Emp;

public class JdbcInsertDemo2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcAppConfig.class);
		EmpDao empDao = ctx.getBean(EmpDaoJdbcImpl.class);
		//System.out.println(empDao.save(new Emp(301, "Chatur", "Mumbai", 65000)));
		//empDao.listAll().stream().forEach(e -> System.out.println(e.getEmpName()+" "+e.getSalary()));
		Emp e = empDao.findById(107);
		System.out.println(e.getEmpName()+" "+e.getSalary());
	}

}
