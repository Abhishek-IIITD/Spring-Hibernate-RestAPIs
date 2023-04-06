package com.demo.spring;

//Java Bean - Java class - every var has setters and getters - var are known as properties
public class Message {
	private String header;
	private String body;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String header, String body) {
		super();
		this.header = header;
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
