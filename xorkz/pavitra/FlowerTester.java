package com.xorkz.pavitra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xorkz.pavitra.constant.JdbcConstant;

public class  FlowerTester     {

	public static void main(String[] args) {
		String username = "root";
		String password = "pavidalawai2468";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		try (Connection connection = DriverManager.getConnection(JdbcConstant.URL, JdbcConstant.USERNAME,JdbcConstant. PASSWORD);){
			Class.forName(fqnOfDriverImpl);

		

			String query = "insert into flower_table values(7,'Rose','Tradtional',6,true,true,false,true,true,false,true)";
			String query1 = "insert into flower_table values(2,'Jasmine','Custom',5,false,true,true,false,true,false,true)";
			String query2 = "insert into flower_table values(11,'Mogra','Custom',10,false,true,false,false,true,false,true)";

			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet result=statement.getResultSet();

			System.out.println(connection);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}