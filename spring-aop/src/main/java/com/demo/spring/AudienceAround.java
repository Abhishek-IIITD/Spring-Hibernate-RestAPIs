package com.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AudienceAround {
	
	@Pointcut("execution(* com.demo.spring.*.*(..))") //in arg - return type(method signature). * means any return type. 2 dots indicates any no. of parameters
	public void pcut(){}
	
	@Around("pcut()")
	public Object invoke(ProceedingJoinPoint pjp) throws Throwable{
		takeSeat();
		switchOffMobiles();		
		Object retVal = pjp.proceed(); //will call perform method
		applaud();
		return retVal;
	}
	public void takeSeat() {
		System.out.println("Audience taking seats....");
	}
	public void switchOffMobiles() {
		System.out.println("Audience switched off their mobiles....");
	}
	
	public void applaud() {
		System.out.println("Excellent Performance! Clap! Clap!....");
	}
}
