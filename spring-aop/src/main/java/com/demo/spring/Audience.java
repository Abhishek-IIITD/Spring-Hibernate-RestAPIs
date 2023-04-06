package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//cross cutting module. Audience is "Aspect". Aspect is the combination of methods present in this class
//@Component
@Aspect
public class Audience {
	
	@Pointcut("execution(* com.demo.spring.*.*(..))") //in arg - return type(method signature). * means any return type. 2 dots indicates any no. of parameters
	public void pcut(){}
	
	@Before("pcut()")  //before advice. In arg -> pointcut (before what is point cut)
	public void takeSeat() {
		System.out.println("Audience taking seats....");
	}
	@Before("pcut()")
	public void switchOffMobiles() {
		System.out.println("Audience switched off their mobiles....");
	}
	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("Excellent Performance! Clap! Clap!....");
	}
}
