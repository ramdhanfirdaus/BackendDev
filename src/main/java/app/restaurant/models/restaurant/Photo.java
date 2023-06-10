package app.restaurant.models.restaurant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name="photo")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Photo {
    @Id
    @Column(name = "id_photo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPhoto;

    @NotNull
    @Column(name = "url", nullable = false)
    private String url;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Restaurant restaurant;
}
