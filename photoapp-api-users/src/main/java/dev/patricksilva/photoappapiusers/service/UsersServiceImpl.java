package dev.patricksilva.photoappapiusers.service;

import java.util.UUID;

import dev.patricksilva.photoappapiusers.shared.UserDto;

public class UsersServiceImpl implements UsersService {

    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        return null;
    }

}
