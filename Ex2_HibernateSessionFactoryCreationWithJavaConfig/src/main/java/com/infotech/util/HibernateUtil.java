package com.infotech.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	static {
		// Creating StandardServiceRegistryBuilder
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

		// Hibernate settings which is equivalent to hibernate.cfg.xml's properties
		Map<String, String> dbSettings = new HashMap<>();
		dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/kk_study_hibernate");
		dbSettings.put(Environment.USER, "root");
		dbSettings.put(Environment.PASS, "manager");
		dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

		// Apply database settings
		registryBuilder.applySettings(dbSettings);
		// Creating registry
		standardServiceRegistry = registryBuilder.build();
		// Create MetadataSources
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		// Create Metadata
		Metadata metadata = metadataSources.getMetadataBuilder().build();
		// Create SessionFactory
		sessionFactory = metadata.getSessionFactoryBuilder().build();

	}

	// Utility method to return SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
