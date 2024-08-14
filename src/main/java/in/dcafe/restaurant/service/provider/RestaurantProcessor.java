package in.dcafe.restaurant.service.provider;


import in.dcafe.restaurant.dto.NewRestaurantRequest;
import in.dcafe.restaurant.entity.Restaurant;
import in.dcafe.restaurant.repository.RestaurantRepository;
import in.dcafe.restaurant.service.RestaurantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestaurantProcessor implements RestaurantManager {

    @Autowired
    RestaurantRepository repository;

    @Override
    public Restaurant newRestaurant(NewRestaurantRequest request) {
        return repository.save(buildRestaurant(request));
    }

    @Override
    public List<Restaurant> all() {
        return repository.findAll();
    }

    private Restaurant buildRestaurant(NewRestaurantRequest request) {
        return Restaurant.builder()
                .restaurantName(request.restaurantName())
                .category(request.category())
                .dietary(request.dietary())
                .types(request.types())
                .items(request.items())
                .build();
    }
}
