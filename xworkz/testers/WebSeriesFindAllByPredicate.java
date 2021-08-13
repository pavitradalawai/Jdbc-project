package www.com.xworkz.testers;


import java.util.Collection;

import www.com.xworkz.dao.WebSeriesDAOImpl;
import www.com.xworkz.dto.WebSeriesDTO;

public class WebSeriesFindAllByPredicate {

	public static void main(String[] args) {
		
		WebSeriesDAO dao = new WebSeriesDAOImpl();
		Collection<WebSeriesDTO> collection = dao.findall();
		collection.forEach(dto -> System.out.println(dto));
		System.out.println(collection);
	

	}

}


	