package com.hibernate.HbDemo;

import javax.persistence.Embeddable;

@Embeddable
public class EmbeddableObject 
{
	@Override
	public String toString() {
		return "EmbeddableObject [City=" + city + ", Address=" + address + "]";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String city;
	private String address;
}
