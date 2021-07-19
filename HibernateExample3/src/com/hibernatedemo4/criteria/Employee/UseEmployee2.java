package com.hibernatedemo4.criteria.Employee;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.hibernatedemo3.hibernate.Employee.Employee;

public class UseEmployee2 {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		System.out.println("Config created!");
		cfg.configure();
        System.out.println("Configure called!");
		SessionFactory sf=cfg.buildSessionFactory();
		System.out.println("Sf created!");
		Session sess=sf.openSession();
		
		Criteria c = sess.createCriteria(Employee.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter salary : ");
		double sal = sc.nextDouble();
//		Criterion cr = Restrictions.gt("sal", sal);
		Criterion crr = Restrictions.le("sal", sal);
		c.add(crr);
		List <Employee> empList = c.list();
		Iterator <Employee> itr = empList.iterator();
		while(itr.hasNext()) {
			Employee e = itr.next();
			System.out.println(e);
		}
		sess.close();
		sf.close();
		sc.close();
	}
}
