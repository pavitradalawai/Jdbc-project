package com.xworkz.restaurant;

import java.util.Collection;

import com.xworkz.resaurant.dto.RestaurantDTO;
import com.xworkz.restaurant.constant.RestaurantType;
import com.xworkz.restaurant.dao.RestaurantDAO;
import com.xworkz.restaurant.dao.RestaurantDAOImpl;
public class RestaurantTester {

	public static  void main(String[] args) {
		// TODO Auto-generated method stub

	RestaurantDTO dto = new RestaurantDTO("Dwaraka","Desai Circle","Dosa",true,RestaurantType.FAST_FOOD);
	RestaurantDTO dto1 = new RestaurantDTO("Udapi","Ashok Circle","voda",true,RestaurantType.FAMILY);
	RestaurantDTO dto2 = new RestaurantDTO("Park","Mudhol road","fingerchips",true,RestaurantType.SELF_SERVICE);
    RestaurantDAO dao =  new RestaurantDAOImpl();
    dao.save(dto);
    dao.save(dto1);
    dao.save(dto2);
    System.out.println(dao.findByName("Dwaraka"));
    Collection<RestaurantDTO>collection= dao.findByType(RestaurantType.FAST_FOOD);
    collection.forEach(ref->System.out.println(ref));
    System.out.println(dao.updateTypeByName(RestaurantType.FAMILY,"Udapi"));
    System.out.println(dao.deleteByTypeAndName(RestaurantType.SELF_SERVICE, null));
}
}
