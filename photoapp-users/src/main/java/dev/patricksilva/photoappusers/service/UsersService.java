package dev.patricksilva.photoappusers.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import dev.patricksilva.photoappusers.shared.UserDto;

public interface UsersService extends UserDetailsService {
	UserDto createUser(UserDto userDetails);

	UserDto getUserDetailsByEmail(String email);
}
