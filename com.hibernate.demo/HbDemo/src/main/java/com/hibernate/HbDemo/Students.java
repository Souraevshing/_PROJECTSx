package com.hibernate.HbDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Students 
{
	@Override
	public String toString() {
		return "Students [roll=" + roll + ", marks=" + marks + ", name=" + name + "]";
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Id
	private int roll;
	private int marks;
	private String name;
	@ManyToMany(mappedBy="students",fetch=FetchType.EAGER)
	private List<Laptop> laptop = new ArrayList<>();
}
