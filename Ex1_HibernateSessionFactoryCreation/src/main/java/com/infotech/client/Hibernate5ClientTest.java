package com.infotech.client;

import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory();
		getAllEmployeesUsingHQL(sf);
	}

	private static void deleteEmployeeById(SessionFactory sf){
		int empId=2;
		try(Session session=sf.openSession()){
			String HQL="DELETE FROM Employee WHERE employeeId=:empId";
	
			Query query=session.createQuery(HQL);
			query.setParameter("empId",empId);
	
			session.beginTransaction();
			int executeUpdate=query.executeUpdate();
			session.getTransaction().commit();
			if(executeUpdate>0){
				System.out.println(executeUpdate+ "records are updated successfully ");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

private static void updateEmployeeEmailById(SessionFactory sf){
	int empId=2;
	String newEmail="martin.b2007@gmail.com";
	try(Session session=sf.openSession()){
		String HQL="UPDATE Employee set email=:newEmail WHERE employeeId=:empId";

		Query query=session.createQuery(HQL);
		query.setParameter("newEmail",newEmail);
		query.setParameter("empId",empId);

		session.beginTransaction();

		int executeUpdate=query.executeUpdate();
		if(executeUpdate>0){
			System.out.println(executeUpdate+ "records are updated successfully ");
		}
		session.getTransaction().commit();
	}catch(Exception e){
		e.printStackTrace();
	}
}

	private static void getAllEmployeesIdAndName(SessionFactory sf){
		try(Session session=sf.opensession()){
			String HQL="SELECT employeeId,employeeName FROM Employee";
			Query query = session.createQuery(HQL);
			List<Object[]> list=query.list();

			for (Object[] objects:list){
				Integer employeeId=(Integer)objects[0];
				String employeeName=(String)objects[1];
				System.out.println(employeeId+"\t"+employeeName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void getAllEmployeesName(SessionFactory sf){
		try(Session session=sf.opensession()){
			String HQL="SELECT employeeName FROM Employee";

			Query<String> query=session.createQuesry(HQL);
			query.list().forEach(System.out::println);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void getEmployeeByIdAndEmail(SessionFactory sf){
		try(Session session=sf.openSession()){
			int empId=2;
			String email="martin.b2017@gmail.com";
			String HQL="FROM Employee WHERE employeeId=:empId AND email=:email";
			Query<Employee> query=session.createQuery(HQL,Employee.class);

			query.setParameter("email",email);
			query.setParameter("empId",empId);

			Employee employee=query.uniqueResult();
			System.out.println(employee);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void getEmployeeById(SessionFactory sf){
		try(Session session=sf.openSession()){
			String HQL="FROM Employee WHERE employeeId=?";
			Query<Employee> query=session.createQuery(HQL,Employee.class);

			query.setParameter(1,empId);

			Employee employee=query.uniqueResult();
			System.out.println(employee);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void getAllEmployees(SessionFactory sf){
		try(Session session=sf.openSession()){
			String HQL="FROM Employees";
			// String HQL="FROM com.infotech.entities.Employee";

			Query<Employee> query=session.createQuery(HQL,Employee.class);
			List<Employee> list=query.list();
			list.forEach(System.out::println);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
