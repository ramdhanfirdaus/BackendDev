package app.restaurant.models.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name="restaurant")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Restaurant {
    @Id
    @Column(name = "id_restaurant")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Photo> photos;

    @ManyToMany
    @JoinTable(name = "restaurant_category",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @NotNull
    @Column(name = "rating", nullable = false)
    private float rating;

    @NotNull
    @Column(name = "price", nullable = false)
    private float price;

    @NotNull
    @Column(name = "is_open", nullable = false)
    private Boolean isOpen;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> review;
}
