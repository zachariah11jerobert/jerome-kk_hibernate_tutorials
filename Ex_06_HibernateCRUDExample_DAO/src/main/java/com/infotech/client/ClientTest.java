package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.service.EmployeeService;
import com.infotech.service.impl.EmployeeServiceImpl;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
//		createEmployee(employeeService);
		getEmployeeById(employeeService);
		//updateEmployeeById(employeeService);
		//deleteEmployeeById(employeeService);
	}

	private static void deleteEmployeeById(EmployeeService employeeService) {
		employeeService.deleteEmployeeById(1);
	}

	private static void updateEmployeeById(EmployeeService employeeService) {
		employeeService.updateEmployeeById(1, 60000.00);
	}

	private static void getEmployeeById(EmployeeService employeeService) {
		Employee employee = employeeService.getEmployeeById(1);
		System.out.println(employee);
	}

	private static void createEmployee(EmployeeService employeeService) {
		employeeService.createEmployee(getEmployee());
	}

	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Martin Bingel");
		employee.setEmail("martin.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}

}
