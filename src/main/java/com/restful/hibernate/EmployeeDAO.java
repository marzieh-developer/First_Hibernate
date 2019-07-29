/**
 * 
 */
package com.restful.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class EmployeeDAO {
	
	SessionFactory sf = new Configuration().configure("/resource/hibernate.cfg.xml").buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
/////////////////////////////////////////////////// post
	public Employee addEmployee(Employee emp) {
		emp.setAge(emp.getAge());
		emp.setId(emp.getId());
		emp.setName(emp.getName());

		
			session.save(emp);
			tx.commit();
			session.close();
		return emp;

	}
///////////////////////////////////////////////////get
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Employee> getEmployees() {			
		try {
		Query query=session.createQuery("from Employee");//here persistent class name is Emp  
		List<Employee> list=query.list(); 
		tx.commit();
		return list;

		}finally {
		session.close();
		}
	}   	
////////////////////////////////////////////////delete
	@SuppressWarnings({ "rawtypes" })
	public int deleteEmployee(int id) {
		try {
		
		Query query=session.createQuery("delete from Employee where id =: id"); 
		query.setInteger("id", id);
		query.executeUpdate(); 
		tx.commit();
		}finally {
		session.close();
		}
		return id;
	}
//////////////////////////////////////////////update
	@SuppressWarnings({ "rawtypes" })
	public int updateEmployee(int id, Employee emp) {
	try {
		Query query=session.createQuery("update Employee  set name=:name , age=:age where id=:id"); 
		query.setInteger("id", id);
		query.setParameter("name",emp.getName());  
		query.setInteger("age",emp.getAge());  
		  
		int status=query.executeUpdate(); 
		tx.commit();
		return status;

	}finally{
		session.close();

	}
	}

}
