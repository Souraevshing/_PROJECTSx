package com.hibernatedemo2.hibernate.Employee;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UseEmployee {
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		System.out.println("Config created!");
		cfg.configure();
		System.out.println("Configure called!");
		SessionFactory sf=cfg.buildSessionFactory();
		System.out.println("Sf created!");
		Session sess=sf.openSession();
		Scanner kb=new Scanner(System.in);
		//boolean done=true;
	    Transaction tx=null;
	    try {
	    	tx=sess.beginTransaction();
//			System.out.println("Enter empno");
//			int empNo=kb.nextInt();
			for(int i=1;i<=9;i++)
			{
				System.out.println("Enter empname");
				String empName=kb.next();
				System.out.println("Enter empsal");
				double empSal=kb.nextDouble();
				Employee e=new Employee();
//			   	e.setEmpNo(empNo);
				e.setEmpName(empName);
				e.setEmpSal(empSal);
				System.out.println("Saving object in session");
				sess.save(e);
			}
			    System.out.println("Commiting...");
			    tx.commit();
	    }
	    catch(HibernateException hb) {
	    		System.out.println("Exception occurred:");
	    		hb.printStackTrace();
	    		tx.rollback();
	    }
	    finally {
	    		sess.close();
	    		sf.close();
	    		kb.close();
	    		System.out.println("Session closed");
	    }
	}
}