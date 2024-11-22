package com.projectJEE.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectJEE.tables.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
	
	Optional<Place> findById(Long id);
}
