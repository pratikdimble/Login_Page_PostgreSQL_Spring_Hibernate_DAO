package com.delegate;

import org.hibernate.HibernateException;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOFactory;
import com.domain.Employee;

public class Employee_Delegate {
	public String addEmployee(String empName,double salary)
	{
		EmployeeDAO dao=null;
		Employee employee=null;
		int empId=0;
		//use dAO
		dao=EmployeeDAOFactory.getInstance();
		
		//prepare Employee objec
		employee=new Employee();
		employee.setEmpName(empName);
		employee.setSalary(salary);
		String msg=null;
		//invoke method
		try{
		 empId=dao.saveEmployee(employee);
		 msg=" Employee Added Succesfully with Id::"+empId;
		}
		catch(HibernateException he){
			he.printStackTrace();
//			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			e.printStackTrace();
//			throw new InternalProblemException(e.getMessage());
		}
		return msg;
	}//method


}
