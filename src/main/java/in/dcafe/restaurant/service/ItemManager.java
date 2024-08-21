package in.dcafe.restaurant.service;


import in.dcafe.restaurant.dto.response.Items;
import in.dcafe.restaurant.dto.response.ItemsByName;
import in.dcafe.restaurant.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ItemManager {

    List<ItemsByName> byName(String itemName);
    List<Items> all();
}
