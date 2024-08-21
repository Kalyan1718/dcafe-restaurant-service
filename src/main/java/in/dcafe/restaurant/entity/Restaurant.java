package in.dcafe.restaurant.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.dcafe.restaurant.utils.ListConverter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@Getter
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

    @Convert(converter = ListConverter.class)
    private List<String> category;

    private String dietary;

    @Convert(converter = ListConverter.class)
    private List<String> types;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "res_add", referencedColumnName = "restaurantId")
    private Set<Address> addresses;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "restaurant_items",
            joinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurantId"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "itemId")
    )
//    @JsonManagedReference
    private Set<Item> items;

}
