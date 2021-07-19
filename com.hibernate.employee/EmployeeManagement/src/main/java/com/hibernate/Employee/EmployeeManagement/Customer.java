package com.hibernate.Employee.EmployeeManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO or Entity class to set values to db

@Entity
@Table(name="Customer")
public class Customer 
{
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id
	@Column(name="Customer_Id")
	private int id;
	@Column(name="Customer_Name")
	private String name;
}
