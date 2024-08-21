package in.dcafe.restaurant.dto.request;


import in.dcafe.restaurant.entity.Address;

import java.util.Set;


public record NewRestaurantOutlet(
        Long restaurantId,
        Set<Address> addresses
) {}
