package com.hibernatedemo3.hibernate.Employee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UseEmployee2 {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		System.out.println("Config created!");
		cfg.configure();
        System.out.println("Configure called!");
		SessionFactory sf=cfg.buildSessionFactory();
		System.out.println("Sf created!");
		Session sess=sf.openSession();
		try {
			Query q2 = sess.createQuery("select e.name,e.sal from Employee e");
			List<Object[]>e = q2.list();
			Iterator<Object[]> it=e.iterator();
			System.out.println("NAME\tSALARY\n");
			while(it.hasNext()) {
				   Object [] data=it.next();
				   System.out.println(data[0]+"\t"+data[1]+"\n");
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
