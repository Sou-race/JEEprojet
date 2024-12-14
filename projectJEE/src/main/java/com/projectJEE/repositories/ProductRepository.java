package com.projectJEE.repositories;

import com.projectJEE.tables.Product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// Find By :
	Optional<Product> findByName(String name);
	Optional<Product> findById(Long id);
	
	// Find All :
	@Query("SELECT p FROM Product p LEFT JOIN p.stock s ORDER BY s.shelfNumber ASC NULLS LAST")
	List<Product> findAllOrderByShelfNumberAsc();
	@Query("SELECT p FROM Product p LEFT JOIN p.stock s ORDER BY s.shelfNumber DESC NULLS FIRST")
	List<Product> findAllOrderByShelfNumberDesc();

}
