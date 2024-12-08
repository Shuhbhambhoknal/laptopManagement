package com.olm.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.olm.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(username).get();
	}

}
