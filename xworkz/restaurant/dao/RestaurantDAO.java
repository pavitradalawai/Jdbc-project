package com.xworkz.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import com.xworkz.resaurant.dto.RestaurantDTO;
import com.xworkz.restaurant.constant.RestaurantType;

	
public interface RestaurantDAO{

		String URL = null;
		String USERNAME = null;
		String PASSWORD = null;

		int save(RestaurantDTO dto);

		RestaurantDTO findByName(String name);

		Collection<RestaurantDTO> findByType(RestaurantType type);

		default boolean updateTypeByName(RestaurantType newtype, String name) {
			
			Connection connect = null;
			
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
				connect=conn;
				conn.setAutoCommit(false);
				String updatequery = "update restaurant_table set r_type='"+newtype+"'"+ "where r_name='" + name + "'";
				Statement st = conn.createStatement();
				st.execute(updatequery);
				conn.commit();
				return true;
			}
			 catch (SQLException e) {
				e.printStackTrace();
				try {
					connect.rollback();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
						
			}
		
			return false;
		}
		
		default boolean deleteByTypeAndName(RestaurantType type,String name) {
			try(Connection connect = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
				connect.setAutoCommit(false);
				String query = "delete from restaurant_table where r_type='"+type+"' and r_name='"+name+"'";
				Statement ste = connect.createStatement();
				ste.execute(query);
				connect.commit();
				return true;
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			   try {
				Connection connect = null;
				connect.rollback();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			return false;
		}
	}

