package com.hibernate.Employee.EmployeeManagement;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//Main class to create session and connect to db

public class HibernateUtil 
{
	static Logger logger = Logger.getLogger(HibernateUtil.class);
	private static SessionFactory factory;
	private HibernateUtil()
	{
		
	}
	static
	{
		try {
			Configuration cfg = new Configuration();
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			factory = cfg.buildSessionFactory(registry);	
			System.out.println(factory);
		}
		catch(Exception ex) {
			System.out.println("Exception in session factory creation!"+ex);

		}
	}
	public static SessionFactory getSessionFactory()
	{
		return factory;
	}
}
