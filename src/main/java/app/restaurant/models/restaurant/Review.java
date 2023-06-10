package app.restaurant.models.restaurant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name="review")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Review {
    @Id
    @Column(name = "id_review")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    @NotNull
    @Column(name = "image", nullable = false)
    private String image;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "rating", nullable = false)
    private float rating;

    @NotNull
    @Column(name = "text", nullable = false)
    private String text;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Restaurant restaurant;
}
