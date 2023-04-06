package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Dependency Injection in Spring
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");// new ClassPathXmlApplicationContext("context.xml") -> this is spring container
		//our application has the spring
		
		//Mail mail = (Mail) ctx.getBean("mail"); //search by name
		Mail mail = ctx.getBean(Mail.class); //search by type
		

		System.out.println(mail.getMessage().getBody());
		Mail mail1 = ctx.getBean(Mail.class); //search by type
		System.out.println(mail==mail1); //return false as it is using prototype and not using scope as singleton
	
	}

}
