package dev.patricksilva.photoappapiusers.service;

import dev.patricksilva.photoappapiusers.shared.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
