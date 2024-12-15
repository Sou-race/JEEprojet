package com.projectJEE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectJEE.repositories.PlaceRepository;
import com.projectJEE.repositories.ProductRepository;
import com.projectJEE.repositories.StockRepository;
import com.projectJEE.tables.Place;
import com.projectJEE.tables.Product;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Transactional
    public void deleteProductWithAssociations(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        for (Place place : product.getPlaces()) {
            place.getDispoProduct().remove(product);
            placeRepository.save(place); 
        }


        if (product.getStock() != null) {
            stockRepository.delete(product.getStock());
        }


        productRepository.delete(product);
    }
}
