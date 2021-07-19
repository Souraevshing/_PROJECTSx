package com.hibernate.Employee.EmployeeManagement;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAO implements ICustomer 
{
	public void addCustomer(Customer c1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(c1);
        tx.commit();
        session.close();
	}
	public Customer readCustomer(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Customer c2 = (Customer)session.get(Customer.class, id);
        session.close();
        return c2;
	}
	public void updateCustomer(Integer id,String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customer c3 = (Customer) session.get(Customer.class, id);
        c3.setName(name);
        session.update(c3);
        tx.commit();
        session.close();
	}
	public void deleteCustomer(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customer c4 = (Customer) session.get(Customer.class, id);
        session.delete(c4);
        tx.commit();
        session.close();
	}
}
