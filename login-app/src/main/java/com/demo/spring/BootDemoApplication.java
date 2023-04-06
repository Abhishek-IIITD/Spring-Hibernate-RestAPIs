package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//configuration file
//dispatcher servlet will be configured automatically
@SpringBootApplication
public class BootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args); //web application context is automatically created through run method. BootDemoApplication.class is the app config file. 
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
		return vr;
	}
}
