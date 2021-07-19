package com.hibernate.HbDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class PersistenceCycle 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory factory = cfg.buildSessionFactory(registry);
		Session sess = factory.openSession();
		sess.beginTransaction();
		
		
		sess.beginTransaction().commit();
		sess.close();
	}
}
