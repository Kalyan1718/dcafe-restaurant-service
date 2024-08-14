package in.dcafe.restaurant.dto;


import in.dcafe.restaurant.entity.Item;

import java.util.List;
import java.util.Set;


public record NewRestaurantRequest (
        String restaurantName,
        List<String> category,
        String dietary,
        List<String> types,
        Set<Item> items
) {}
