package com.infotech.client;

import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String SQL = "SELECT version()";
			String result = (String) session.createNativeQuery(SQL).getSingleResult();
			System.out.println("MySQL version is:::");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
