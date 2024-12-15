package com.projectJEE.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectJEE.repositories.EffectAndPreparationRepository;
import com.projectJEE.repositories.PlaceRepository;
import com.projectJEE.repositories.ProductRepository;
import com.projectJEE.repositories.StockRepository;
import com.projectJEE.tables.EffectAndPreparation;
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

	    @Autowired
	    private EffectAndPreparationRepository effectAndPreparationRepository;

	    @Transactional
	    public void deleteProductWithAssociations(Long productId) {
	        
	        Product product = productRepository.findById(productId)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	       
	        Set<Place> places = new HashSet<>(product.getPlaces()); 
	        for (Place place : places) {
	            place.getDispoProduct().remove(product); 
	            product.getPlaces().remove(place);       
	            placeRepository.save(place);            
	        }

	        
	        if (product.getStock() != null) {
	            stockRepository.delete(product.getStock());
	        }
	        
	        List<EffectAndPreparation> effects = product.getPossibleEffectsAnfPreparations();
	        for (EffectAndPreparation effect : effects) {
	            effectAndPreparationRepository.delete(effect);
	        }

	        
	        productRepository.delete(product);
	    }
}
