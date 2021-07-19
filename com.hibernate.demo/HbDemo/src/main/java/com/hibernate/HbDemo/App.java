package com.hibernate.HbDemo;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App
{
	public static void main(String[] args) 
	{
		
		Configuration cfg = new Configuration();
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory factory = cfg.buildSessionFactory(registry); 
		
		Client e1=new Client();	
		e1.setId(107);
		e1.setFirstName("Souraev");
		e1.setLastName("Shing");
		Scanner sc = new Scanner(System.in);
		Session session1 = factory.openSession();
		session1.beginTransaction();
		
		Query q1 = session1.createQuery("from Client where id=101");
		e1 = (Client) q1.uniqueResult();
		
		session1.getTransaction().commit();
		session1.close();
		Session session2 = factory.openSession();
		session2.beginTransaction();
		e1 = (Client)session2.get(Client.class, 103);
		System.out.println(e1);
		session2.getTransaction().commit();
		session2.close();
		/**System.out.println("Enter City Name : ");
		String city = sc.next();
		e2.setCity(city);
		System.out.println("Enter Address : ");
		String addr = sc.next();
		e2.setAddress(addr);
		e1.setEmbeddableObject(e2);
		System.out.println("Enter ID : ");
		int eid = sc.nextInt();
	    e1.setId(eid);
	    
	    System.out.println("Enter First Name : ");
	    String fname = sc.next();
	    e1.setFirstName(fname);
	    System.out.println("Enter Last Name : ");
	    String lname = sc.next();
	    e1.setLastName(lname);*/
	
	    sc.close();
	    factory.close();  
	}
}
