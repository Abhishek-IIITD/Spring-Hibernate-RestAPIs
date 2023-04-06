package com.demo.hibernate;

import javax.persistence.*;

@Entity
@Table(name="PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
