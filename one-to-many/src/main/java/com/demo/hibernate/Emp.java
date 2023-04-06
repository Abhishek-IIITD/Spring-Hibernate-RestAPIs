package com.demo.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="MYEMP")
public class Emp {
	@Id
	@Column(name="EMPNO")
    private int empid;
	
	@Column(name="NAME")
    private String empName;
	
	@Column(name="ADDRESS")
    private String city;
	
	//@Column(name="SALARY") //not needed as column name and field name is same
    private double salary;
    
    @ManyToOne
    @JoinColumn(name = "DNO") //it will tell what is the foreign key for this relation
    private Dept dept;

public Emp() {
	// TODO Auto-generated constructor stub
}

public Emp(int empid, String empName, String city, double salary) {
	super();
	this.empid = empid;
	this.empName = empName;
	this.city = city;
	this.salary = salary;
}

public int getEmpid() {
	return empid;
}

public void setEmpid(int empid) {
	this.empid = empid;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public Dept getDept() {
	return dept;
}

public void setDept(Dept dept) {
	this.dept = dept;
}


}
