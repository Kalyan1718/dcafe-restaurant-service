package in.dcafe.restaurant.dto;


import in.dcafe.restaurant.entity.Item;

import java.util.Set;


public record NewItemInRestaurantRequest(
        Long restaurantId,
        Set<Item> items
) {}
