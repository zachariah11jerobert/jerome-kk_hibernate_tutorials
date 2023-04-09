package com.infotech.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
		Employee employee = null;
		
	}

	private staticvoid getEmployeeAndAddressByEmployeeId(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Sting HQL="SELECT emp.employeeName, emp.salary,city,pincode FROM Employee emp LEFT JOIN emp.addrList addr WHERE employeeId=:empId";

			Query<Employee> query=session.createQuery(HQL,Employee.class);
			query.setParameter("empId",1);

			Employee employee=query.uniqueResult();
			System.out.println(employee);
			if(employee !=null){
				employee.getAddressList().forEach(System.out::println);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private staticvoid getEmployeeAndAddressByEmployeeId2(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Sting HQL="SELECT emp.employeeName, emp.salary,city,pincode FROM Employee emp LEFT JOIN emp.addrList addr WHERE employeeId=:empId";

			Query<Object[]> query=session.createQuery(HQL);
			query.setParameter("empId",1);

			List<Object[]> list=query.list();

			for(Object[] objects:list){
				String employeeName=(String)objects[0];
				Double sal=(Double)objects[1];
				String city=(String)objects[2];
				Long pincode=(Long)objects[3];
				System.out.println(employeeName+"\t"+sal+"\t"+city+"\t"+pincode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
