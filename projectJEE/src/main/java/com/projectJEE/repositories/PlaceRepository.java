package com.projectJEE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectJEE.tables.Category;

@Repository
public interface PlaceRepository extends JpaRepository<Category, Long>{

}
