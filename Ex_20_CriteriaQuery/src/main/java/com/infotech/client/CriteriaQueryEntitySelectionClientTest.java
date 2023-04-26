package com.infotech.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class CriteriaQueryEntitySelectionClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery=builder.createQuery(Employee.class);
			
			// since entity is not have relation we use Root
			Root<Employee> root=criteriaQuery.from(Employee.class);
			criteriaQuery.select(root);

			// this place we build criteria
			criteriaQuery.where(builder.equal(root.get("employeeId"),2));

			Query<Employee> query=session.createQuery(criteriaQuery);
			List<Employee> empList=query.list();
			empList.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
