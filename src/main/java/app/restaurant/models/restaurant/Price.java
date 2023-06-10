package app.restaurant.models.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name="price")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Price {
    @Id
    @Column(name = "id_price")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrice;

    @NotNull
    @Column(name = "nominal", nullable = false, unique = true)
    private float nominal;
}
