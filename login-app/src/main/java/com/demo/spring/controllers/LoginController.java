package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//spring boot application created from start.spring.io website
@Controller
public class LoginController {
	//inject empDao interface. Use Autowired annotation to convert the application to JPA
	@RequestMapping(path="login", method=RequestMethod.GET)
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	public ModelAndView processForm(@RequestParam("username") String name, @RequestParam("password") String pwd) {
		ModelAndView mv = new ModelAndView();
		System.out.println("User is being authenticated..");
		if(name.equals(pwd)) {
			mv.setViewName("success"); //create success.jsp
			mv.addObject("name", name);
		}else {
			mv.setViewName("failure");
		}
		return mv;
	}
}
