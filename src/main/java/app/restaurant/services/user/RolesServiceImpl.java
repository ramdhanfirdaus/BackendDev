package app.restaurant.services.user;

import app.restaurant.models.user.Roles;
import app.restaurant.models.user.RolesEnum;
import app.restaurant.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    RoleRepository roleRepository;

    public Roles findByName(RolesEnum name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    @Override
    public Set<Roles> assignRoles(Set<String> strRoles) {
        Set<Roles> roles = new HashSet<>();

        if (strRoles == null) {
            Roles userRole = findByName(RolesEnum.USER);
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if (role.equals("ADMIN")) {
                    Roles adminRole = findByName(RolesEnum.ADMIN);
                    roles.add(adminRole);
                } else {
                    Roles userRole = findByName(RolesEnum.USER);
                    roles.add(userRole);
                }
            });
        }

        return roles;
    }
}
