package com.infotech.client;

import java.util.Date;

import com.infotech.model.EmployeeStatistics;
import com.infotech.model.EmployeeStatistics;
import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String HQL="SELECT new com.infotech.model.EmployeeStatistics(COUNT(e) , AVG(e.salary),MIN(e.salary),SUM(e.salary)) FROM Employee e";

			Query<EmployeeStatistics> query=session.createQuery(HQl,EmployeeStatistics.class);
			EmployeeStatistics employeeStatistics=query.uniqueResult();

			System.out.println("Total no. of Employees:"+employeeStatistics.getEmpCount());
			System.out.println("Avg salary:"+employeeStatistics.getAvgSal());
			System.out.println("Min salary:"+employeeStatistics.getMinSal());
			System.out.println("Sum of Salary:"+employeeStatistics.getSumOfSal());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
