package in.dcafe.restaurant.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Set<Item> items;
}
