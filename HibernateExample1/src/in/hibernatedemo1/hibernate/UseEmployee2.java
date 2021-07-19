package in.hibernatedemo1.hibernate;

import java.util.Scanner;

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
	   Scanner kb=new Scanner(System.in);
	   System.out.println("Enter emp no:");
	   int eno=kb.nextInt();
	   System.out.println("Calling load first time");
	   kb.close();
	   Employee e=(Employee)sess.load(in.hibernatedemo1.hibernate.Employee.class,eno);
	   
	   if(e!=null) {
		   System.out.println("EmpNo:"+e.getEmpNo());
		   System.out.println("Ename:"+e.getEmpName());
		   System.out.println("Sal:"+e.getEmpSal());
	   }
	   else {
		   System.out.println("Record not found");
	   }
	   System.out.println("Calling load second time");
	   e=(Employee)sess.load(in.hibernatedemo1.hibernate.Employee.class,eno);
	   if(e!=null) {
		   System.out.println("EmpNo:"+e.getEmpNo());
		   System.out.println("Ename:"+e.getEmpName());
		   System.out.println("Sal:"+e.getEmpSal());
	   }
	   else {
		   System.out.println("Record not found");
	   }
	   
	   sess.close();
	   sf.close();
	   
	   
	
}
}
