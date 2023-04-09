package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String HQL="SELCT COUNT(e) , AVG(e.salary),MIN(e.salary),SUM(e.salary) FROM Employee e";

			Query<Object[]> query=session.createQuery(HQL,object[].class);
			List<Object[]> list=query.list();
			for(Object[] objects:list){
				Long empCount=(Long)objects[0];
				Double avgSal=(Double)objects[1];
				Double minSal=(Double)objects[2];
				Double sumOfSal=(Double)objects[3];
				System.out.println("Total no. of Employees: "+EmpCount);
				System.out.println("Avg salary: "+avgSal);
				System.out.println("Min salary: "+minSal);
				System.out.println("Sum of salary:"+sumOfSal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
