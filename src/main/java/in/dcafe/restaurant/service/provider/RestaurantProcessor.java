package in.dcafe.restaurant.service.provider;


import in.dcafe.restaurant.dto.request.NewItemInRestaurant;
import in.dcafe.restaurant.dto.request.NewRestaurant;
import in.dcafe.restaurant.dto.request.NewRestaurantOutlet;
import in.dcafe.restaurant.entity.Address;
import in.dcafe.restaurant.entity.Item;
import in.dcafe.restaurant.entity.Restaurant;
import in.dcafe.restaurant.repository.RestaurantRepository;
import in.dcafe.restaurant.service.RestaurantManager;

import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestaurantProcessor implements RestaurantManager {

    @Autowired RestaurantRepository repository;

    @Override
    public Restaurant newRestaurant(NewRestaurant request) {
        return repository.save(buildRestaurant(request));
    }

    @Override
    public List<Restaurant> all() { return ensureRestaurants(repository.findAll()); }

    private List<Restaurant> ensureRestaurants(List<Restaurant> restaurants) {
        if (restaurants.isEmpty()) {
            throw new NoResultException("No Restaurants found!");
        }
        return restaurants;
    }

    @Override
    public Restaurant newItemInRestaurant(NewItemInRestaurant request) {
        Restaurant restaurant = byId(request.restaurantId());
        return repository.save(addNewItemInRestaurant(request, restaurant));
    }

    @Override
    public Restaurant byId(Long restaurantId) {
        return repository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("No Restaurant found with given id: %d", restaurantId)
                ));
    }

    @Override
    public Restaurant newOutlet(NewRestaurantOutlet request) {
        Restaurant restaurant = byId(request.restaurantId());
        return repository.save(addNewRestaurantOutlet(request, restaurant));
    }

    private Restaurant buildRestaurant(NewRestaurant request) {
        return Restaurant.builder()
                .restaurantName(request.restaurantName())
                .category(request.category())
                .dietary(request.dietary())
                .types(request.types())
                .items(request.items())
                .build();
    }

    private Restaurant addNewItemInRestaurant(NewItemInRestaurant request, Restaurant restaurant) {

//        Set<Item> items = new HashSet<>();
//        items.addAll(restaurant.getItems());
//        items.addAll(request.items());

//        Set<Item> items = restaurant.getItems();
//        for (Item item : request.items()) {
//               items.add(item);
//        }
        for(Item item: request.items()) {
            System.out.println("Item: " + item);
            System.out.println("boolean: " + (!restaurant.getItems().contains(item)));
            System.out.println("Restaurant item: " + restaurant.getItems());
            if(!restaurant.getItems().contains(item)){
//                System.out.println("Restaurant item: " + restaurant.getItems());
                System.out.println("Adding item...");
                restaurant.getItems().add(item);
            }
        }
//        restaurant.getItems().addAll(request.items());
//        restaurant.setItems(items);
        return restaurant;
    }

    private Restaurant addNewRestaurantOutlet(NewRestaurantOutlet request, Restaurant restaurant) {
//        for(Address address: request.addresses()) {
//            System.out.println("Address: " + address);
////            if(!request.addresses().contains(address)) {
//                restaurant.getAddresses().add(address);
////            }
//        }
        restaurant.getAddresses().addAll(request.addresses());
        return restaurant;
    }
}
