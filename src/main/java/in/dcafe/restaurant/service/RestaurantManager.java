package in.dcafe.restaurant.service;


import in.dcafe.restaurant.dto.NewRestaurantRequest;
import in.dcafe.restaurant.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RestaurantManager {
    Restaurant newRestaurant(NewRestaurantRequest request);

    List<Restaurant> all();
}
