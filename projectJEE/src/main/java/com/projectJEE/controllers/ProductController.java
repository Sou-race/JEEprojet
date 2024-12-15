package com.projectJEE.controllers;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectJEE.repositories.ProductRepository;
import com.projectJEE.tables.Product;

@Controller
public class ProductController {
	
	@Autowired 
	ProductRepository productRepository;
	
	
	/// Affichage : 
	
	@GetMapping("/products/{id}")
	 public String showProductModal(@PathVariable Long id, Model model) {
	     List<Product> products = productRepository.findAll();
	     model.addAttribute("products", products);

	     Product selectedProduct = productRepository.findById(id)
	             .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	     model.addAttribute("selectedProduct", selectedProduct);

	     return "products";
	 }
	
	
	@GetMapping("/products")
	public String showProducts(
	        @RequestParam(defaultValue = "id") String sort,
	        @RequestParam(defaultValue = "asc") String order,
	        Model model) {
		
		// Si trie :
	    List<Product> products;
	    if ("shelfNumber".equals(sort)) {	   
	    	// Trie par stock :
	        products =  order.equals("asc") ? productRepository.findAllOrderByShelfNumberAsc() :productRepository.findAllOrderByShelfNumberDesc();	
	        
	    } else {
	    	// Autres tries normaux :
	    	Sort.Direction direction = order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
	        products = productRepository.findAll(Sort.by(direction, sort));
	    }
	    
	    model.addAttribute("products", products);
	    return "products";
	}
	
	
	// Recherche :
	
	@GetMapping("/api/products/search")
    @ResponseBody
    public List<Map<String,Object>> searchProducts(@RequestParam("query") String query) {
		List<Product> byName = productRepository.findByNameStartingWithIgnoreCase(query);
		List<Product> byDescription = productRepository.findByDescriptionContainingIgnoreCase(query);
		Set<Product> products = new LinkedHashSet<>();
	    products.addAll(byName);
	    products.addAll(byDescription);
        return products.stream()
        				.limit(10)
		        		.map(product -> {
		                    Map<String, Object> suggestion = new HashMap<>();
		                    suggestion.put("name", product.getName());
		                    suggestion.put("id", product.getId());
		                    suggestion.put("description", product.getDescription());
		                    return suggestion;
		                })
		                .collect(Collectors.toList());
	}
	
	
	/// Ajout :
	
	 @PostMapping("/products")
	 Product newProduct(@RequestBody Product newProduct) {
	    return productRepository.save(newProduct);
	  }
	 
	 //TODO : ajouter des ProductNotFoundException ? au cas où
	 @DeleteMapping("/products/{id}")
	  void deleteProduct(@PathVariable Long id) {
		 productRepository.deleteById(id);
	  }
	 
	 /*
	 @GetMapping("/products/{id}")
	 @ResponseBody
	 public Product getProductById(@PathVariable Long id) {
	     return productRepository.findById(id)
	             .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	 }
	 */
	 
}
