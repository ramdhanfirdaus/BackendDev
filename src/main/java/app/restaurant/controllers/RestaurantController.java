package app.restaurant.controllers;

import app.restaurant.services.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllRestaurant() {
        return ResponseEntity.ok(restaurantService.getAllRestaurant());
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping("/by-category/{category}")
    public ResponseEntity<?> getRestaurantByCategory(@PathVariable String category) {
        return ResponseEntity.ok(restaurantService.getRestaurantByCategory(category));
    }

    @GetMapping("/price")
    public ResponseEntity<?> getAllPrice() {
        return ResponseEntity.ok(restaurantService.getAllPrice());
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(restaurantService.getAllCategory());
    }
}
