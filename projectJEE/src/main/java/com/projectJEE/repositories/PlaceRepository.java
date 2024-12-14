package com.projectJEE.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectJEE.tables.Place;

import jakarta.persistence.OrderBy;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
	@OrderBy("name")
	Optional<Place> findByName(String name);	
	
	
	List<Place> findAllByOrderByName();
}