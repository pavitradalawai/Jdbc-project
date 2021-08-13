package www.com.xworkz.testers;


import www.com.xworkz.dao.WebSeriesDAOImpl;
import www.com.xworkz.dto.WebSeriesDAO;

public class WebSeriesFindAllTester {

	public static void main(String[] args) {
		WebSeriesDAOImpl dao = new WebSeriesDAOImpl();
		System.out.println(dao.findall());

	}


}
