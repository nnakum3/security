package com.security.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<User> user = userRepo.findByUserName(username);
		return user.map(UserDetail::new).orElseThrow(()->new UsernameNotFoundException(username+ " not found"));
	}

}
