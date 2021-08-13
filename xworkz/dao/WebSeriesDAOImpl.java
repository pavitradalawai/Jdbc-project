package www.com.xworkz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import www.com.xworkz.dto.WebSeriesDAO;
import www.com.xworkz.dto.WebSeriesDTO;
import www.com.xworkz.jdbcConstants.JDBCConstant;
import www.com.xworkz.webenum.Genertype;
import www.com.xworkz.webenum.StreamedInType;

public class WebSeriesDAOImpl implements WebSeriesDAO, WebSeriesDAO {
	List<WebSeriesDTO> collection = new ArrayList<WebSeriesDTO>();

	@Override
	public int save(WebSeriesDTO dto) {
		System.out.println("Saving dto in database");
		int aild = 0;
		Connection tempcon = null;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			tempcon = connection;
			connection.setAutoCommit(false);
			String query = "insert into webseries(name,noOfEpisodes,streamedIn,gener,yestAgeIndaNodbohudu) values (?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int w_noOfEpisodes = resultSet.getInt("noOfEpisodes");
				String w_streamedIn = resultSet.getString("streamedIn");
				String w_gener = resultSet.getString("gener");
				int w_yestAgeIndaNodbohudu = resultSet.getInt("yestAgeIndaNodbohudu");
				WebSeriesDTO dto1 = new WebSeriesDTO(name, w_noOfEpisodes, StreamedInType.valueOf(w_streamedIn),
						Genertype.valueOf(w_gener), w_yestAgeIndaNodbohudu);
				dto1.setW_id(id);
				collection.add(dto1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			try {
				tempcon.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return aild;
	}

	@Override
	public Collection<WebSeriesDTO> saveAll(Collection<WebSeriesDTO> collection) {

		System.out.println("Saving dto in database");

		// Collection<WebSeriesDTO> dto = new ArrayList<WebSeriesDTO>();
		Connection tempcon = null;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			tempcon = connection;
			// connection.setAutoCommit(false);
			String query = "insert into webseries(name,noOfEpisodes,streamedIn,gener,yestAgeIndaNodbohudu) values (?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int w_noOfEpisodes = resultSet.getInt("noOfEpisodes");
				String w_streamedIn = resultSet.getString("streamedIn");
				String w_gener = resultSet.getString("gener");
				int w_yestAgeIndaNodbohudu = resultSet.getInt("yestAgeIndaNodbohudu");
				WebSeriesDTO dto1 = new WebSeriesDTO(name, w_noOfEpisodes, StreamedInType.valueOf(w_streamedIn),
						Genertype.valueOf(w_gener), w_yestAgeIndaNodbohudu);
				dto1.setW_id(id);
				collection.add(dto1);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return collection;
	}

	@Override
	public Collection<WebSeriesDTO> findall() {

		System.out.println("Find all data's from table");
		Collection<WebSeriesDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "SELECT * FROM Webseries";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int w_noOfEpisodes = resultSet.getInt("noOfEpisodes");
				String w_streamedIn = resultSet.getString("streamedIn");
				String w_gener = resultSet.getString("gener");
				int w_yestAgeIndaNodbohudu = resultSet.getInt("yestAgeIndaNodbohudu");
				WebSeriesDTO dto = new WebSeriesDTO(name, w_noOfEpisodes, StreamedInType.valueOf(w_streamedIn),
						Genertype.valueOf(w_gener), w_yestAgeIndaNodbohudu);
				dto.setW_id(id);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<WebSeriesDTO> findall(Predicate<WebSeriesDTO> predicate) {
		Collection<WebSeriesDTO> temp = new ArrayList<WebSeriesDTO>();
		this.collection.forEach(w -> {
			if (predicate.test(w)) {
				temp.add(w);
			}
		});
		return temp;

	}

	@Override
	public int total() {
		int value = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			String count = "select * from webseries";

			Statement statement = connection.createStatement();
			statement.execute(count);
			ResultSet resultset = statement.getResultSet();
			int counts = 0;

			while (resultset.next()) {
				value = counts++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}

	@Override
	public Collection<WebSeriesDTO> findAllSortByNameDesc() {

		System.out.println("Find all data's from table name in decending order");
		Collection<WebSeriesDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "select * from webseries order by name desc";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int w_noOfEpisodes = resultSet.getInt("noOfEpisodes");
				String w_streamedIn = resultSet.getString("streamedIn");
				String w_gener = resultSet.getString("gener");
				int w_yestAgeIndaNodbohudu = resultSet.getInt("yestAgeIndaNodbohudu");
				WebSeriesDTO dto = new WebSeriesDTO(name, w_noOfEpisodes, StreamedInType.valueOf(w_streamedIn),
						Genertype.valueOf(w_gener), w_yestAgeIndaNodbohudu);
				dto.setW_id(id);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Optional<WebSeriesDTO> findone(Predicate<WebSeriesDTO> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMaxEpisodes() {

		int value = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			String max = " select * from webseries where noOfEpisodes = (select max(noOfEpisodes) from webseries) ";

			PreparedStatement statement = connection.prepareStatement(max);
			statement.execute(max);
			ResultSet resultset = statement.getResultSet();

			if (resultset.next()) {
				value = resultset.getInt("noOfEpisodes");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}

	@Override
	public int findMinEpisodes() {
		int value = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			String max = " select * from webseries where noOfEpisodes = (select min(noOfEpisodes) from webseries) ";

			PreparedStatement statement = connection.prepareStatement(max);
			statement.execute(max);
			ResultSet resultset = statement.getResultSet();

			if (resultset.next()) {
				value = resultset.getInt("noOfEpisodes");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}
}
