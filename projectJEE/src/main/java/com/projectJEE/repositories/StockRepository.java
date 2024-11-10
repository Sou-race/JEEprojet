package com.projectJEE.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectJEE.tables.Product;
import com.projectJEE.tables.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	Optional<Stock> findByShelfNumber(int shelfNumber);
	//Optional<Stock> findByProduct(Product stockedProduct);
}
