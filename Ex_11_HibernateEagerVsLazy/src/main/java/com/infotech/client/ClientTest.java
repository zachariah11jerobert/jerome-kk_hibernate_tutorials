package com.infotech.client;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, 1);
			System.out.println(employee);
			if (employee != null) {
				employee.getAddressList().forEach(System.out::println);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
