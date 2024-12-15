package com.projectJEE.controllers;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectJEE.repositories.ProductRepository;
import com.projectJEE.repositories.StockRepository;
import com.projectJEE.services.ProductService;
import com.projectJEE.tables.Product;
import com.projectJEE.tables.ProductType;


@Controller
public class ProductController {
	
	@Autowired 
	ProductRepository productRepository;
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	ProductService productService;
	
	/// Affichage : 
	@GetMapping("/products")
	public String showProducts(
			@RequestParam(required = false) Long idProduct,
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
	    
	    // Si produit spécifique à afficher :
	    if(idProduct!=null) {
	    	Product selectedProduct = productRepository.findById(idProduct)
		             .orElseThrow(() -> new RuntimeException("Product not found with id: " + idProduct));
		     model.addAttribute("selectedProduct", selectedProduct);
	    }
	     
	    return "products";
	}
	
	
	@GetMapping("/addNewProduct")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product()); // Passe un objet vide de type Product
        return "new-product-form"; // Vue HTML contenant le formulaire
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
        				.limit(5)
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
	 
	 
	 @PostMapping("/addNewProduct")
	    public String saveNewProduct(
	            @RequestParam String name,
	            @RequestParam String otherNames,
	            @RequestParam("type") ProductType type,
	            @RequestParam String description,
	            @RequestParam String picLink,
	            @RequestParam int shelfNumber,
	            @RequestParam float quantity,
	            @RequestParam String unit,
	            @RequestParam float pricePerUnit,
	            Model model) {
		 	List<String> otherNamesList = Arrays.asList(otherNames.split("/"));
	            productService.saveProductWithStock(
	                name, otherNamesList, type, description, picLink,
	                shelfNumber, quantity, unit, pricePerUnit
	            );
	            return "redirect:/products";
	        
	    }
	 
	 
	 
	 @PostMapping("/products/{id}/edit")
	    public String editProduct(@PathVariable Long id, 
	                              @RequestParam String name,
	                              @RequestParam String description,
	                              @RequestParam String otherNames,
	                              @RequestParam String picLink,
	                              Model model) {
	        
	        Product product = productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	        
	        product.setName(name);
	        product.setDescription(description);
	        product.setOtherNames(Arrays.asList(otherNames.split("/")));
	        product.setPicLink(picLink);

	     
	        productRepository.save(product);

	        return "redirect:/products"; 
	    }
	 
	 //TODO : ajouter des ProductNotFoundException ? au cas où
	 /*@DeleteMapping("/products/{id}")
	  void deleteProduct(@PathVariable Long id) {
		 productRepository.deleteById(id);
	  }*/
	 
	 
	 @DeleteMapping("/products/{id}")
	 @ResponseBody
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	        productService.deleteProductWithAssociations(id);
	        return ResponseEntity.ok("Product, its stock, and its associations were deleted successfully");
	    }
	 
}
