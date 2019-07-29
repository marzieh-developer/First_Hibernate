/**
 * 
 */
package com.restful.hibernate;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {

	public Employee addEmployee(Employee emp) {
		emp.setAge(emp.getAge());
		emp.setId(emp.getId());
		emp.setName(emp.getName());

		SessionFactory sf = new Configuration().configure("/resource/hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
		} finally {
			session.close();
		}
		return emp;

	}

	
	public List<Employee> getEmployees() {
		
		Query query=session.createQuery("from Employee");//here persistent class name is Emp  
		List list=query.list();  
		System.out.print("sallllllllammmm");

	}

   	

	public int deleteEmployee(int id) {
		Query query=session.createQuery("delete from Emp where id=100");  
		query.executeUpdate();  
		return id;
	}

	public int updateEmployee(int id, Employee emp) {
		return 0;
	}

}
