package www.com.xworkz.testers;


import java.util.ArrayList;
import java.util.Collection;

import www.com.xworkz.dao.WebSeriesDAO;
import www.com.xworkz.dao.WebSeriesDAOImpl;
import www.com.xworkz.dto.WebSeriesDTO;

public class WebSeriesFindAllCollectionTester {

	public static void main(String[] args) {
		Collection<WebSeriesDTO> dto = new ArrayList<WebSeriesDTO>();
		WebSeriesDAO dao = new WebSeriesDAOImpl();
		System.out.println(dao.saveAll(dto));

	}

}

