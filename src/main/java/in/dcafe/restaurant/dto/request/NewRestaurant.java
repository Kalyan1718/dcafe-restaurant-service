package in.dcafe.restaurant.dto.request;


import in.dcafe.restaurant.entity.Item;

import java.util.List;
import java.util.Set;


public record NewRestaurant (
        String restaurantName,
        List<String> category,
        String dietary,
        List<String> types,
        Set<Item> items
) {}
