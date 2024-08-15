package in.dcafe.restaurant.service.provider;


import in.dcafe.restaurant.dto.NewItemInRestaurantRequest;
import in.dcafe.restaurant.dto.NewRestaurantRequest;
import in.dcafe.restaurant.entity.Restaurant;
import in.dcafe.restaurant.repository.RestaurantRepository;
import in.dcafe.restaurant.service.RestaurantManager;

import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        return ensureRestaurants(repository.findAll());
    }

    private List<Restaurant> ensureRestaurants(List<Restaurant> restaurants) {
        if(restaurants.isEmpty()) {
            throw new NoResultException("No Restaurants found!");
        }
        return restaurants;
    }

    @Override
    public Restaurant newItemInRestaurant(NewItemInRestaurantRequest request) {
        Restaurant restaurant = repository.findById(request.restaurantId())
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Restaurant found with given id: %s", request.restaurantId())
                ));
        return repository.save(addNewItemInRestaurant(request, restaurant));
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

    private Restaurant addNewItemInRestaurant(NewItemInRestaurantRequest request, Restaurant restaurant) {
        restaurant.getItems().addAll(request.items());
        return restaurant;
    }
}
