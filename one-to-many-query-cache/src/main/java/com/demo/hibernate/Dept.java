package com.demo.hibernate;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "MYDEPT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="DEPT_CACHE")
public class Dept {
	@Id
	@Column(name="DNO")
	private int deptNo;
	@Column(name="DNAME")
	private String deptName;
	@Column(name="MANAGER")
	private String manager;

	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy="dept") //updation will not be done from this side enforced by "mappedBy". It will ensure relation is not updated from Dept side. That means DNO foreign key is not updated. This is similar to not inserting any rows
	//@JoinColumn(name = "DNO")
	private Set<Emp> emps = new HashSet<>();
	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public Dept(int deptNo, String deptName, String manager) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.manager = manager;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}
