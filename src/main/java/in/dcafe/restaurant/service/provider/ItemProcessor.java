package in.dcafe.restaurant.service.provider;

import in.dcafe.restaurant.entity.Item;
import in.dcafe.restaurant.repository.ItemRepository;
import in.dcafe.restaurant.service.ItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemProcessor implements ItemManager {

    @Autowired
    ItemRepository repository;

    @Override
    public List<Item> all() {
        return repository.findAll();
    }
}
