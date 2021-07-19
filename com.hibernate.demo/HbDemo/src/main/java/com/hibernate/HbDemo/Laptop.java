package com.hibernate.HbDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Laptop
{
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + "]";
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
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	@Id
	private int id;
	private String name;
	@ManyToMany
	private List<Students> students = new ArrayList<>();
}
