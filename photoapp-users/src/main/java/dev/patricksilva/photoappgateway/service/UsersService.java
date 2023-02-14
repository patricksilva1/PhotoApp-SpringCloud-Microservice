package dev.patricksilva.photoappgateway.service;

import dev.patricksilva.photoappgateway.shared.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
