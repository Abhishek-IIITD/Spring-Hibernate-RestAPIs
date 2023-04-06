package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args); //web application context is automatically created through run method. BootDemoApplication.class is the app config file. 
	}

}
