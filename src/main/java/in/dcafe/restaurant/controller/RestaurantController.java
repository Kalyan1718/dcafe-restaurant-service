package in.dcafe.restaurant.controller;


import in.dcafe.restaurant.dto.request.NewItemInRestaurant;
import in.dcafe.restaurant.dto.request.NewRestaurant;
import in.dcafe.restaurant.dto.request.NewRestaurantOutlet;
import in.dcafe.restaurant.entity.Restaurant;
import in.dcafe.restaurant.service.RestaurantManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static in.dcafe.restaurant.constant.MediaTypes.JSON;


@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    @Autowired RestaurantManager manager;

    @PostMapping(path = "/add", consumes = JSON, produces = JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addRestaurant(@RequestBody NewRestaurant request) {
        return manager.newRestaurant(request);
    }

    @PostMapping(path = "/items/add", consumes = JSON, produces = JSON)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Restaurant addItemInRestaurant(@RequestBody NewItemInRestaurant request) {
        return manager.newItemInRestaurant(request);
    }

    @PostMapping(path = "/address/add", consumes = JSON, produces = JSON)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Restaurant addRestaurantOutlet(@RequestBody NewRestaurantOutlet request) {
        return manager.newOutlet(request);
    }

    @GetMapping(path = "/all", produces = JSON)
    public List<Restaurant> all() {
        return manager.all();
    }

    @GetMapping(path = "/{restaurantId}", produces = JSON)
    public Restaurant byRestaurantId(@PathVariable Long restaurantId) {
        return manager.byId(restaurantId);
    }

}
