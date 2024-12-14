package com.projectJEE.controllers;


import java.util.List;

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
