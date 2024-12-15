package com.projectJEE.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectJEE.repositories.PlaceRepository;
import com.projectJEE.repositories.ProductRepository;
import com.projectJEE.services.PlaceService;
import com.projectJEE.tables.Place;
import com.projectJEE.tables.Product;

@Controller
public class PlaceController {

	@Autowired 
	PlaceRepository placeRepository;
	
	@Autowired
    PlaceService placeService;
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/places")
	public String showPlacesById(Model model) {
		List<Place> places = placeRepository.findAllByOrderByName();
		model.addAttribute("places", places);
		
		List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        
		return "places";
	}
	
	@PostMapping("/{placeId}/add-product")
	@ResponseBody
	public ResponseEntity<String> addProductToPlace(@PathVariable Long placeId, @RequestParam Long productId) {
	    System.out.println("Adding product with ID: " + productId + " to place with ID: " + placeId);
	    placeService.addProductToPlace(placeId, productId);
	    return ResponseEntity.ok("Product added to place successfully");
	}
	
	@DeleteMapping("/{placeId}/remove-product/{productId}")
	@ResponseBody
	public ResponseEntity<String> removeProductFromPlace(@PathVariable Long placeId, @PathVariable Long productId) {
	    System.out.println("Removing product with ID: " + productId + " from place with ID: " + placeId);
	    placeService.removeProductFromPlace(placeId, productId);
	    return ResponseEntity.ok("Product removed from place successfully");
	}
    
    @GetMapping("/places/edit/{id}")
    public String editPlace(@PathVariable Long id, Model model) {
        Place place = placeRepository.findById(id).orElse(new Place());
        model.addAttribute("placeToEdit", place);
        model.addAttribute("places", placeRepository.findAllByOrderByName());
        return "places";
    }
    
    @PostMapping("/places/save")
    public String savePlace(@RequestParam(required = false) Long id,
                            @RequestParam String name,
                            @RequestParam int latitude,
                            @RequestParam int longitude) {
        Place place = (id != null) ? placeRepository.findById(id).orElse(new Place()) : new Place();
        place.setName(name);
        place.setLatitude(latitude);
        place.setLongitude(longitude);
        placeRepository.save(place);
        return "redirect:/places";
    }
    
    @PostMapping("/places/delete")
    public String deletePlace(@RequestParam Long id) {
        placeRepository.deleteById(id);
        return "redirect:/places";
    }
    
    
}
