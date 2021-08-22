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
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		Connection connection = null;
		try {
			Class.forName(fqnOfDriverImpl);

			connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);

			String query = "insert into flower_table values(9,'','Custom',13,true,true,false,true,true,false,true)";
			Statement statement = connection.createStatement();
			statement.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
