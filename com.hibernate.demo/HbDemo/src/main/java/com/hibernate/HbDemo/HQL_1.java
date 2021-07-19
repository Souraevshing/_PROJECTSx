package com.hibernate.HbDemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import oracle.net.aso.q;

public class HQL_1
{
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory factory = cfg.buildSessionFactory(registry);
		Session sess = factory.openSession();
		sess.beginTransaction();
		
		TypedQuery<Empl> fetch = sess.createQuery("from Empl");
		TypedQuery<Empl> q2 = sess.createQuery("select id,name,age,sal from Empl");
		
		List<Empl>e = fetch.getResultList();
		System.out.println("Displaying single result...\n");
		System.out.println(e+"\n");
		
//		List<Empl> e2 = (List<Empl>)q2.getResultList();
//		for(Empl e4 : e2)
//		System.out.println(e4.getAge()+e4.getId()+e4.getName()+e4.getSal());
		
		System.out.println("Displaying all details...");
		for(Empl e3 : e)
			
		System.out.println(e3.getId()+"\t"+e3.getName()+"\t"+e3.getAge()+"\t"+e3.getSal()+"\n");
		
		sess.getTransaction().commit();
		sess.close();
		factory.close();
	}
	
}
