package com.sl.ecom.service.jwt;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sl.ecom.Repository.UserRepository;
import com.sl.ecom.entity.User;


@Service
public class UserDetailsServiceImpl {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findFirstByEmail(username);
		
		if(optionalUser.isEmpty()) throw new UsernameNotFoundException("Username not found" ,null);

		return new org.springframework.security.core.userdetails.User(
			optionalUser.get().getEmail(),
			optionalUser.get().getPassword(),
			new ArrayList<>()
		);
		
	}

}
