package com.hibernatedemo3.hibernate.Employee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee3 {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		System.out.println("Config created!");
		cfg.configure();
        System.out.println("Configure called!");
		SessionFactory sf=cfg.buildSessionFactory();
		System.out.println("Sf created!");
		Session sess=sf.openSession();
		try {
			Query q1 = sess.createQuery("select e.name from Employee e");
			List <String> queryList = q1.list();
			Iterator <String> itr = queryList.iterator();
			   while(itr.hasNext()) {
				   String str = itr.next();
				   System.out.println(str);
			   }
		}
		catch(HibernateException hb) {
			System.out.println("Exception "+hb);
		}
		finally {
			sess.close();
			System.out.println("Session closed!");
			sf.close();
			System.out.println("Session Factory closed!");
		}
	}
}
