package in.dcafe.restaurant.dto.request;


import in.dcafe.restaurant.entity.Item;

import java.util.Set;


public record NewItemInRestaurant(
        Long restaurantId,
        Set<Item> items
) {}
