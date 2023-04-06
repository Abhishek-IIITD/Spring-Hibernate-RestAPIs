package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.impl.EmpDaoMockImpl;
//Spring app using annotations
//Loader to application context - alternate to context.xml
//@Component
@Configuration //is itself a component. You can check by hovering mouse pointer over it
@ComponentScan(basePackages = "com.demo.spring") //it will scan all subpackages as well and will load the annotated classes. This loading of beans would faster than xml parsing
public class AppConfig {
	@Bean //this is method level
	public EmpDao mock3() {
		return new EmpDaoMockImpl();
	}
	
	@Bean
	public EmpDao mock4(String s) { //this will work only if we have public String hi() method
		System.out.println("mock4-2");
		return new EmpDaoMockImpl();
	}
	
	//@Bean
	public EmpDao mock4() {
		System.out.println("mock4-1");
		return new EmpDaoMockImpl();
	}
	
	@Bean
	public String hi() {
		return "hi";
	}
	@Bean //if it is annotated with bean, then only it will be called by spring framework when the file is loaded with application context
	public DriverManagerDataSource ds() { //converting third party class file to spring bean
		return new DriverManagerDataSource();
	}

}
