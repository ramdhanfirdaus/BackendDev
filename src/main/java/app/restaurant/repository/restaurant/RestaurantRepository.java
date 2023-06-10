package app.restaurant.repository.restaurant;

import app.restaurant.models.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.categories")
    List<Restaurant> findAll();

    @Query("SELECT DISTINCT r FROM Restaurant r WHERE r.idRestaurant = :idRestaurant")
    Restaurant findAllByIdRestaurant(@Param("idRestaurant") Long idRestaurant);

    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.categories c WHERE c.nameCategory = :categoryName")
    List<Restaurant> findAllByCategoryName(@Param("categoryName") String categoryName);

}
