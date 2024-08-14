package in.dcafe.restaurant.controller;


import in.dcafe.restaurant.dto.NewRestaurantRequest;
import in.dcafe.restaurant.entity.Restaurant;
import in.dcafe.restaurant.service.RestaurantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static in.dcafe.restaurant.constant.MediaTypes.JSON;


@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantManager manager;

    @PostMapping(path = "/add", consumes = JSON, produces = JSON)
    public Restaurant addRestaurant(@RequestBody NewRestaurantRequest request) {
        return manager.newRestaurant(request);
    }

    @GetMapping(path = "/all", produces = JSON)
    public List<Restaurant> all() {
        return manager.all();
    }
}
