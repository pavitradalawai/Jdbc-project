package com.xorkz.pavitra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JasmineTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "pavidalawai2468";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fnqOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		try (Connection connection = DriverManager.getConnection(url, username, password);) {
			Class.forName(fnqOfDriverImpl);

			
			String query="insert into flower_table values(5,'jasmine','Tradtional',7,true,true,false,true,true,false,true)";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet result = statement.getResultSet();

			System.out.println(connection);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}