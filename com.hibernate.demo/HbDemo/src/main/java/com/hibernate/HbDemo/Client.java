package com.hibernate.HbDemo;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.*;


@Entity
@Table(name="Client")
@Cacheable()
@org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

public class Client {  
@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
@Id
private int id;
@Column(name="FirstName")
private String firstName;
@Column(name="LastName")
private String lastName;

private EmbeddableObject o;  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getFirstName() {  
    return firstName;  
}  
public void setFirstName(String firstName) {  
    this.firstName = firstName;  
}  
public String getLastName() {  
    return lastName;  
}  
public void setLastName(String lastName) {  
    this.lastName = lastName;  
}
public EmbeddableObject getEmbeddableObject() {
	return o;
}
public void setEmbeddableObject(EmbeddableObject o) {
	this.o = o;
}  
}  