package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {

	}

	private static void getEmployeeInfo() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(EmployeeDTO.class);
			Root<Employee> root = criteriaQuery.form(Employee.class);

			Path<Object> employeeNamePath = root.get("employeeName");
			Path<Object> emailPath = root.get("email");
			Path<Object> salaryPath = root.get("salary");

			criteriaQuery.select(builder.construct(EmployeeDTO.class, employeeNamePath, emailPath, salaryPath));

			List<Tuple> tuples = session.createQuery(criteriaQuery).getResultList();
			for (Tuple tuple : tuples) {
				String employeeName = (String) tuple.get(employeeNamePath);
				String email = (String) tuple.get(emailPath);
				Double sal = (Double) tuple.get(employeeNamePath);
				System.out.println(employeeName+"\t"+email+"\t"+sal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
