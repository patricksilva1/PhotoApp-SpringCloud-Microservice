package dev.patricksilva.photoappapiusers.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import dev.patricksilva.photoappapiusers.shared.UserDto;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
	UserDto getUserByUserId(String userId);
}
