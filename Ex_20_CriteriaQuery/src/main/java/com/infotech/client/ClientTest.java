package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery=builder.createQuery(Employee.class);
			Root<Employee> root=criteraiQuery.form(Employee.class);
			CriteriaQuery.select(root);

			criteriaQuery.where(builder.equal(root.get("employeeId"),2))

			Query<Employee> query=session.createQuesry(criteriaQuery);
			List<Employee> empList=query.list();
			empList.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
