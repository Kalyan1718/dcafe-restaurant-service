package in.dcafe.restaurant.service;


import in.dcafe.restaurant.dto.request.NewItemInRestaurant;
import in.dcafe.restaurant.dto.request.NewRestaurant;
import in.dcafe.restaurant.dto.request.NewRestaurantOutlet;
import in.dcafe.restaurant.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RestaurantManager {

    Restaurant newRestaurant(NewRestaurant request);

    List<Restaurant> all();

    Restaurant newItemInRestaurant(NewItemInRestaurant request);

    Restaurant byId(Long restaurantId);

    Restaurant newOutlet(NewRestaurantOutlet request);
}
