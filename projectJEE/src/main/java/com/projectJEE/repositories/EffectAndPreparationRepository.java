package com.projectJEE.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectJEE.tables.EffectAndPreparation;

@Repository
public interface EffectAndPreparationRepository extends JpaRepository<EffectAndPreparation, Long>{
	
	Optional<EffectAndPreparation> findById(Long id);
	
	List<EffectAndPreparation> findAllByOrderByUsedProduct_Name();
}