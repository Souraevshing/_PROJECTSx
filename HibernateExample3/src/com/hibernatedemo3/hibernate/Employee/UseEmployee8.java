package com.hibernatedemo3.hibernate.Employee;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseEmployee8 {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		System.out.println("Config created!");
		cfg.configure();
        System.out.println("Configure called!");
		SessionFactory sf=cfg.buildSessionFactory();
		System.out.println("Sf created!");
		Session sess=sf.openSession();
		try {
			Query qry=sess.createQuery("Select e.name,e.sal from Employee e where e.id>:eid and e.sal>:sal");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id :");
			int eid = sc.nextInt();
			System.out.println("Enter sal :");
			double sal = sc.nextDouble();
			Employee emp = new Employee();
			emp.setId(eid);
			emp.setSal(sal);
			qry.setProperties(emp);
			List <Object[]>empList=qry.list();
			Iterator <Object[]>it=empList.iterator();
			while(it.hasNext()) {
				Object[] data=it.next();
				System.out.println(data[0]+"\t"+data[1]);
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