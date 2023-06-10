package app.restaurant.repository.user;

import app.restaurant.models.user.Roles;
import app.restaurant.models.user.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(RolesEnum name);
}
