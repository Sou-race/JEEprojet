package com.projectJEE.repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectJEE.tables.Product;
import com.projectJEE.tables.Stock;

import jakarta.persistence.OrderBy;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	@OrderBy("shelfNumber")
	Optional<Stock> findByShelfNumber(int shelfNumber);	
	Optional<Stock> findByStockedProduct(Product stockedProduct);
	
	List<Stock> findAllByOrderByShelfNumber();
	List<Stock> findAllByOrderByStockedProduct();
}
