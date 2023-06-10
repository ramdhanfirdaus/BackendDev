package app.restaurant.services.restaurant;

import app.restaurant.models.restaurant.Category;
import app.restaurant.models.restaurant.Price;
import app.restaurant.models.restaurant.Restaurant;
import app.restaurant.repository.restaurant.CategoryRepository;
import app.restaurant.repository.restaurant.PriceRepository;
import app.restaurant.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantByCategory(String category) {
        return restaurantRepository.findAllByCategoryName(category);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findAllByIdRestaurant(id);
    }

    @Override
    public List<Price> getAllPrice() {
        return priceRepository.findAll();
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
