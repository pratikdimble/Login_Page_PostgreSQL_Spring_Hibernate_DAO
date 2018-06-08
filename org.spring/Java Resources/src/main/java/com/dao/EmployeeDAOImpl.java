package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Employee;

import utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int saveEmployee(Employee emp) {
			 Session ses=null;
				ses=HibernateUtil.getSession();
				Transaction tx=null;
				boolean flag=false;
				int id=0;
				try{
				 tx=ses.beginTransaction();
				   //save objs
				 id=(int)ses.save(emp);
		    flag=true;			
				}//try
				catch(HibernateException he){
					flag=false;
					throw he;
				}
				catch(Exception e){
					flag=false;
					throw e;
				}
				finally{
					if(flag){
						tx.commit();
						System.out.println("*****Record inserted with ID:"+id);
						
					}
					else{
						tx.rollback();
					}
				 //close Session
					HibernateUtil.closeSession();
				}//finally
				return id;
		}//method

}
