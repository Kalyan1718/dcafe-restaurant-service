package in.dcafe.restaurant.service.provider;

import in.dcafe.restaurant.dto.response.Items;
import in.dcafe.restaurant.dto.response.ItemsByName;
import in.dcafe.restaurant.repository.ItemRepository;
import in.dcafe.restaurant.service.ItemManager;

import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static in.dcafe.restaurant.repository.Queries.ITEMS_BY_NAME_QUERY;
import static in.dcafe.restaurant.repository.Queries.ITEMS_QUERY;


@Service
public class ItemProcessor implements ItemManager {

    @Autowired ItemRepository repository;

    @Autowired JdbcTemplate template;

    @Override
    public List<ItemsByName> byName(String itemName) {
        List<ItemsByName> items = template.query(ITEMS_BY_NAME_QUERY, new DataClassRowMapper<>(ItemsByName.class), itemName);
        return ensureItemsByName(items);
    }

    private List<ItemsByName> ensureItemsByName(List<ItemsByName> items) {
        if (items.isEmpty()) {
            throw new NoResultException("No Items found!");
        }
        return items;
    }

    @Override
    public List<Items> all() {
        Long start = System.currentTimeMillis();
//        List<Item> allItems = repository.findAll();
//        List<Items> items = new ArrayList<>();
//        for(Item i: allItems) {
//            Items item = new Items(i.getItemId(), i.getItemName(), i.getCategory(), i.getDietary(), i.getType(),
//                    i.getPrice(), i.getRestaurants().stream().map(Restaurant::getRestaurantName).toList());
//            items.add(item);
//        }

        List<Items> items = template.query(ITEMS_QUERY, new DataClassRowMapper<>(Items.class));
        Long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        return ensureItems(items);
    }

    private List<Items> ensureItems(List<Items> items) {
        if (items.isEmpty()) {
            throw new NoResultException("No Items found!");
        }
        return items;
    }
}
