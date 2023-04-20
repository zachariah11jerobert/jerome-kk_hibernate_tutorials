package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			createEmployee(session);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id = (Integer) session.save(getEmployee());
		System.out.println("Employee is created with Id::" + id);
		session.getTransaction().commit();
	}

	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Martin Bingel");
		employee.setEmail("martin.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		
		Address homeAddress=new Address();
		homeAddress.setCity("Chennai");
		homeAddress.setPincode(9087727L);
		homeAddress.setState("Tamilnadu");
		homeAddress.setStreet("Park Street");
		employee.setHomeAddress(homeAddress);
		
		Address officeAddress=new Address();
		officeAddress.setCity("Pune");
		officeAddress.setPincode(9087727L);
		officeAddress.setState("MH");
		officeAddress.setStreet("XYZ Street");
		employee.setOfficeAddress(officeAddress);
		
		return employee;
	}

}
