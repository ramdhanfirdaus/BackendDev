package app.restaurant.services.restaurant;

import app.restaurant.models.restaurant.Category;
import app.restaurant.models.restaurant.Price;
import app.restaurant.models.restaurant.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurant();
    List<Restaurant> getRestaurantByCategory(String category);
    Restaurant getRestaurantById(Long id);
    List<Price> getAllPrice();
    List<Category> getAllCategory();
}
