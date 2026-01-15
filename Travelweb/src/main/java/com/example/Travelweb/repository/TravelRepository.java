package com.example.Travelweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Travelweb.entity.TravelEntity;

public interface TravelRepository extends JpaRepository<TravelEntity, Long> {

	Optional<TravelEntity>findByEmail(String email);//find the email 
	
}
