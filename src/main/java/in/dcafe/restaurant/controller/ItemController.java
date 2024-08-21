package in.dcafe.restaurant.controller;


import in.dcafe.restaurant.dto.response.Items;
import in.dcafe.restaurant.dto.response.ItemsByName;
import in.dcafe.restaurant.service.ItemManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static in.dcafe.restaurant.constant.MediaTypes.JSON;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired ItemManager manager;

    @GetMapping(path = "/{itemName}", produces = JSON)
    public List<ItemsByName> itemByName(@PathVariable String itemName) {
        return manager.byName(itemName);
    }

    @GetMapping(path = "/all", produces = JSON)
    public List<Items> all() {
        return manager.all();
    }
}
