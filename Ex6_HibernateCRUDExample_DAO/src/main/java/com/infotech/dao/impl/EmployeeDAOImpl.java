package com.infotech.dao.impl;

import org.hibernate.Session;

import com.infotech.dao.EmployeeDAO;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee employee) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Integer id = (Integer) session.save(employee);
			System.out.println("Employee is created with Id::" + id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Employee fetchEmployeeById(int employeeId) {
		Employee employee=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			employee = session.get(Employee.class, employeeId);
			if (employee != null) {
				System.out.println(employee);
			} else {
				System.out.println("Employee doesn't exist with provided Id..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void updateEmployeeById(int employeeId, Double newSal) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, employeeId);
			if (employee != null) {
				employee.setSalary(56000.00);
				session.beginTransaction();
				session.update(employee);
				session.getTransaction().commit();
			} else {
				System.out.println("Employee doesn't exist with provided Id...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, employeeId);
			if (employee != null) {
				employee.setSalary(90000.00);
				session.beginTransaction();

				session.delete(employee);
				session.getTransaction().commit();
			} else {
				System.out.println("Employee doesn't exist with provided Id...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
