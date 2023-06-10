package app.restaurant.services.user;

import app.restaurant.models.user.Roles;

import java.util.Set;

public interface RolesService {
    Set<Roles> assignRoles(Set<String> strRoles);
}
