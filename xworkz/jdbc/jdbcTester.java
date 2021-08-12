package com.xworkz.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class jdbcTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String username="root";
String password="pavidalawai2468";
String url="jdbc:mysql://localhost:3306/transformers";
String fqnOfDriverImpl="com.mysql.cj.jdbc.Driver";
try {
	Connection connection=DriverManager.getConnection(url,username,password);
	System.out.println(connection);
	String query="insert into restaurant_tabale values(8,'God','bjp','poha',false,'nonveg')";
	String query2="insert into restaurant_tabale values(9,'good','hkd','idli',true,'veg')";
	Statement statement = connection.createStatement();
	statement.execute(query);
	statement.execute(query2);
}catch (SQLException e) {
	e.printStackTrace();
}

}
	}


