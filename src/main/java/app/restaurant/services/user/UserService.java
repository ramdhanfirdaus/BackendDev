package app.restaurant.services.user;

import app.restaurant.models.user.User;
import app.restaurant.payload.request.SignupRequest;

public interface UserService {
    User getUserByUsername(String username);

    Boolean cekExistsUserByUsername(String username);

    void createUser(SignupRequest signUpRequest);
}
