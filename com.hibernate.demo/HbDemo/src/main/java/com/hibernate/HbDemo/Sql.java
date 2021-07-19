package com.hibernate.HbDemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sql {

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Loaded");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","onlineadvjava","admin");
			System.out.println("conn estd..");
			conn.close();
		}
		catch(Exception sql)
		{
			System.out.println("Exception...");
		}
	}

}
