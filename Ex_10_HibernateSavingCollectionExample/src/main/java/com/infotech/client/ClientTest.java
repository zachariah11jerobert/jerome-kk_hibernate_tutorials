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
//			getEmployeeById(session);
//			updateEmployeeById(session);
//			deleteEmployeeById(session);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void deleteEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if (employee != null) {
			employee.setSalary(90000.00);
			session.beginTransaction();

			session.delete(employee);
			session.getTransaction().commit();
		} else {
			System.out.println("Employee doesn't exist with provided Id...");
		}
	}

	private static void updateEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if (employee != null) {
			employee.setSalary(56000.00);
			session.beginTransaction();

			session.update(employee);
			session.getTransaction().commit();
		} else {
			System.out.println("Employee doesn't exist with provided Id...");
		}
	}

	private static void getEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("Employee doesn't exist with provided Id..");
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
		
		Address address1=new Address();
		address1.setCity("Chennai");
		address1.setPincode(9087727L);
		address1.setState("Tamilnadu");
		address1.setStreet("Park Street");
		
		Address address2=new Address();
		address2.setCity("Chennai");
		address2.setPincode(9087727L);
		address2.setState("Tamilnadu");
		address2.setStreet("Park Street");
		
		employee.getAddressList().add(address1);
		employee.getAddressList().add(address2);
		
		return employee;
	}

}
