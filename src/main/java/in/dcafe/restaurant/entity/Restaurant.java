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
        property = "restaurantId"
)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    private String restaurantName;

    private List<String> category;

    private String dietary;

    private List<String> types;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "restaurant_items",
            joinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurantId"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "itemId")
    )
    private Set<Item> items;

//    public Long getRestaurantId() {
//        return restaurantId;
//    }
//
//    public String getRestaurantName() {
//        return restaurantName;
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
//    public List<String> getTypes() {
//        return types;
//    }
//
//    public Set<Item> getItems() {
//        return items;
//    }
//
//    public Restaurant() {}
//
//    public Restaurant(Long restaurantId, String restaurantName, List<String> category, String dietary, List<String> types, Set<Item> items) {
//        this.restaurantId = restaurantId;
//        this.restaurantName = restaurantName;
//        this.category = category;
//        this.dietary = dietary;
//        this.types = types;
//        this.items = items;
//    }
//
//    @Override
//    public String toString() {
//        return "Restaurant{" +
//                "restaurantId=" + restaurantId +
//                ", restaurantName='" + restaurantName + '\'' +
//                ", category=" + category +
//                ", dietary='" + dietary + '\'' +
//                ", types=" + types +
//                ", items=" + items +
//                '}';
//    }
}
