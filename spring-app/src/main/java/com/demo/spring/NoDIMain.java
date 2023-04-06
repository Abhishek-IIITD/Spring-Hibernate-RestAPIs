package com.demo.spring;
//No Dependency Injection
public class NoDIMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message = new Message("Tea Break", "Tea Break at 4:00pm");
		Mail mail = new Mail();
		mail.setMessage(message);
		mail.setFromAddress("Trainer");
		mail.setToAddress("All");
		System.out.println(mail.getMessage().getBody());
	}

}
