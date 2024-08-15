package in.dcafe.restaurant.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "itemId"
)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;

    private List<String> category;

    private String dietary;

    private String type;

    private double price;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private Set<Restaurant> restaurants;

//    public Long getItemId() {
//        return itemId;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public List<String> getCategory() {
//        return category;
//    }
//
//    public String getDietary() {
//        return dietary;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public Set<Restaurant> getRestaurants() {
//        return restaurants;
//    }
//
//    public Item() {}
//
//    public Item(Long itemId, String itemName, List<String> category, String dietary, String type, double price, Set<Restaurant> restaurants) {
//        this.itemId = itemId;
//        this.itemName = itemName;
//        this.category = category;
//        this.dietary = dietary;
//        this.type = type;
//        this.price = price;
//        this.restaurants = restaurants;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "itemId=" + itemId +
//                ", itemName='" + itemName + '\'' +
//                ", category=" + category +
//                ", dietary='" + dietary + '\'' +
//                ", type='" + type + '\'' +
//                ", price=" + price +
//                ", restaurants=" + restaurants +
//                '}';
//    }
}
