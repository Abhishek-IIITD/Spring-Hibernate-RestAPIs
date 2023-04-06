package com.demo.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> { // no need to create dao and its impl. This
																		// interface JpaRepository will provide already
																		// implemented methods

}
