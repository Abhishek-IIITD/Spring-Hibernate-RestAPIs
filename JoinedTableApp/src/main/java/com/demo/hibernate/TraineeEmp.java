package com.demo.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TRAINEE")
public class TraineeEmp extends Employee{

	private String performance;

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
}
