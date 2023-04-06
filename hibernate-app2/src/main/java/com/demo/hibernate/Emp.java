package com.demo.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="EMP")
public class Emp {
	@Id
	@Column(name="EMPNO")
    private int empId;
	
	@Column(name="NAME")
    private String name;
	
	@Column(name="ADDRESS")
    private String city;
	
	//@Column(name="SALARY") //not needed as column name and field name is same
    private double salary;
    
    @Embedded
    private Address address;
    
    @ElementCollection()
    //@CollectionTable(name="IMAGES",joinColumns=@JoinColumn(columnDefinition="EMPNO"))
    @CollectionTable(name="IMAGES", joinColumns=@JoinColumn(name = "EMPNO"))
    @Column(name = "IMAGE_NAME")
    Set<String> images = new HashSet<>();
    
    public Emp() {
        
    }
    public Emp(int empId, String name, String city, double salary) {
        super();
        this.empId = empId;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<String> getImages() {
		return images;
	}
	public void setImages(Set<String> images) {
		this.images = images;
	}
    
    
}
 