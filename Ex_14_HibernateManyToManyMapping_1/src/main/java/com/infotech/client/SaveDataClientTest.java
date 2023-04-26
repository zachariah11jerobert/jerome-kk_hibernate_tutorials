package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class SaveDataClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Employee employee1 = new Employee();
			employee1.setEmployeeName("Martin Bingel");
			employee1.setEmail("martin.cs2017@gmail.com");
			employee1.setSalary(50000.00);
			employee1.setDoj(new Date());
			
			Employee employee2 = new Employee();
			employee2.setEmployeeName("Sean Bingel");
			employee2.setEmail("sean.cs2017@gmail.com");
			employee2.setSalary(50000.00);
			employee2.setDoj(new Date());
			
			Address address1=new Address();
			address1.setCity("Chennai");
			address1.setPincode(9087727L);
			address1.setState("Tamilnadu");
			address1.setStreet("Park street");
			
			Address address2=new Address();
			address2.setCity("Pune");
			address2.setPincode(9087727L);
			address2.setState("MH");
			address2.setStreet("XYZ street");
			
			Address address3=new Address();
			address3.setCity("Delhi");
			address3.setPincode(9087821L);
			address3.setState("DL");
			address3.setStreet("PQR street");
			
			employee1.getAddressList().add(address1);
			employee1.getAddressList().add(address2);
			employee1.getAddressList().add(address3);
			
			address1.getEmpList().add(employee1);
			address2.getEmpList().add(employee1);
			address3.getEmpList().add(employee1);
			
			employee2.getAddressList().add(address2);
			employee2.getAddressList().add(address3);
			
			address2.getEmpList().add(employee2);
			address3.getEmpList().add(employee2);
			
			session.persist(employee1);
			session.persist(employee2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
