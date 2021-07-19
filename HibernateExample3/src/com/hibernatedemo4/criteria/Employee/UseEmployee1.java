package com.hibernatedemo4.criteria.Employee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo3.hibernate.Employee.Employee;

public class UseEmployee1 {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		System.out.println("Config created!");
		cfg.configure();
        System.out.println("Configure called!");
		SessionFactory sf=cfg.buildSessionFactory();
		System.out.println("Sf created!");
		Session sess=sf.openSession();
		
		Criteria c = sess.createCriteria(Employee.class);
		List <Employee>empList=c.list();
		Iterator <Employee>it=empList.iterator();
		while(it.hasNext())
		{
			Employee e=it.next();
			System.out.println(e);
		}
		sess.close();
		sf.close();
	}
}
