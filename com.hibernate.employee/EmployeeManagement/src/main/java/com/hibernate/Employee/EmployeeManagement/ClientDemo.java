package com.hibernate.Employee.EmployeeManagement;

import java.util.Scanner;

import org.hibernate.HibernateException;

//INPUT values from user and store in db

public class ClientDemo 
{
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		try {
			int i=0;
//			System.out.println("CREATE");
//			System.out.println("Enter Customer details\n");
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter Customer ID\n");
//			int id = sc.nextInt();
//			System.out.println("Enter Customer Name\n");
//			String name = sc.next();
//			
			Customer c = new Customer(101,"Sk");
			dao.addCustomer(c);
			
			System.out.println(i++ + "records inserted successfully!");
			//sc.close();
		}
		catch(HibernateException hb) {
			System.out.println("Exception in ClientDemo"+hb);
		}
	}
}
