package com.xorkz.pavitra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xorkz.pavitra.constant.JdbcConstant;

public class MograTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	

		String username = "root";
		String password = "pavidalawai2468";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fnqOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		try (Connection connection = DriverManager.getConnection(JdbcConstant.URL, JdbcConstant.USERNAME,JdbcConstant.PASSWORD);){
			Class.forName(fnqOfDriverImpl);

			
			String query="insert into flower_table values(8,'mogra','Custom',9,true,true,false,true,true,false,true)";
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
