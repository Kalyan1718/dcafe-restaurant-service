package in.dcafe.restaurant.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "RESTAURANT_ADDRESS")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String blockNo;

    private String road;

    private String area;

    private String city;
    
    private Integer pincode;

    private String district;

    private String state;

}
