package in.dcafe.restaurant.controller;


import in.dcafe.restaurant.entity.Item;
import in.dcafe.restaurant.entity.Restaurant;
import in.dcafe.restaurant.service.ItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static in.dcafe.restaurant.constant.MediaTypes.JSON;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    ItemManager manager;

    @GetMapping(path = "/all", produces = JSON)
    public List<Item> all() {
        return manager.all();
    }
}
