package com.example.Travelweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Travelweb.entity.TravelEntity;
import com.example.Travelweb.repository.TravelRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private TravelRepository travelRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//fetch user from database//
		TravelEntity user=travelRepository.findByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException("User not found")); 
		
		
		return User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER") 
                .build();
	}

}
