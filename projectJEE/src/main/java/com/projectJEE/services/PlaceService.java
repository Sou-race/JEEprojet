package com.projectJEE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectJEE.repositories.PlaceRepository;
import com.projectJEE.repositories.ProductRepository;
import com.projectJEE.tables.Place;
import com.projectJEE.tables.Product;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ProductRepository productRepository;

    

    public Place getPlaceById(Long placeId) {
        return placeRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("Place not found"));
    }

    public void savePlace(Place place) {
        placeRepository.save(place);
    }
    
    public void addProductToPlace(Long placeId, Long productId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("Place not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (!place.getDispoProduct().contains(product)) {
            place.getDispoProduct().add(product);
            product.getPlaces().add(place);
        }
        placeRepository.save(place);
    }

    public void removeProductFromPlace(Long placeId, Long productId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new RuntimeException("Place not found"));
        Product product = place.getDispoProduct().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not associated with this place"));

        place.getDispoProduct().remove(product);
        product.getPlaces().remove(place);

        placeRepository.save(place);
    }
}

