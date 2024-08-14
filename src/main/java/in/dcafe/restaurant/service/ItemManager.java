package in.dcafe.restaurant.service;


import in.dcafe.restaurant.entity.Item;
import in.dcafe.restaurant.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ItemManager {
    List<Item> all();
}
