package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<String> criteriaQuery=builder.createQuery(String.class);
			Root<Employee> root=criteriaQuery.form(Employee.class);
			CriteriaQuery.select(root.get("employeeName"));

			Query<String> createQuery=session.createQuery(criteriaQuery);
			List<String> empNameList=createQuery.getResultList();
			empNameList.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
