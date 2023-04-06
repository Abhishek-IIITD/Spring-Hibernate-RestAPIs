package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//Domain Driven Design application
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//our application has the spring
		
		EmpService service = ctx.getBean(EmpService.class); 
		//DriverManagerDataSource ds = new DriverManagerDataSource();
		
		System.out.println(service.registerEmp(201, "Ankit", "Delhi", 90000));
		

	}

}
