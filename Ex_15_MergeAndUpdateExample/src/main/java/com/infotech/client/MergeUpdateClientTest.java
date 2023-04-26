package com.infotech.client;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class MergeUpdateClientTest {

	public static void main(String[] args) {
		Employee employee1 = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			employee1 = session.get(Employee.class, 1);
			System.out.println(employee1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		employee1.setSalary(65000.00);
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Employee employee2 = session.get(Employee.class, 1);
			
			
			//session.update(employee1);	// since it is a detached session , it wont work
			session.merge(employee1); 	// it will work
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
