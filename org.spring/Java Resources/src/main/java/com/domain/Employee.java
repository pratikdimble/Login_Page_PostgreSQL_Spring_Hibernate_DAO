package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name="EMPLOYEE_DEMO")
public class Employee {
	
	private int empId;
	private String empName;
	private double salary;
	
	public Employee() {
		
		super();
		System.out.println("**** You are in Domain");
	}
	
	@Id
	@Column(name="emp_id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Column(name="emp_name")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(name="emp_sal")

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
	
}
