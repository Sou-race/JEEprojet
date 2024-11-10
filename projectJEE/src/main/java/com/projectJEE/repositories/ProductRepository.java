package com.projectJEE.repositories;

import com.projectJEE.tables.Product;
import com.projectJEE.tables.Stock;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Optional<Product> findByName(String name);
	//Optional<Product> findByStockShelf(Stock stock);
}
