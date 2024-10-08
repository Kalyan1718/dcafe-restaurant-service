package in.dcafe.restaurant.repository;


import in.dcafe.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {}
