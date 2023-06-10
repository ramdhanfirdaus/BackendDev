package app.restaurant.models.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Table(name="category")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @NotNull
    @Size(max = 50)
    @Column(name = "name_category", nullable = false, unique = true)
    private String nameCategory;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private List<Restaurant> restaurants;
}
