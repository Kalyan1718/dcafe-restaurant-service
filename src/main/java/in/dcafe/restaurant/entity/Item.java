package in.dcafe.restaurant.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Set<Restaurant> restaurants;

}
