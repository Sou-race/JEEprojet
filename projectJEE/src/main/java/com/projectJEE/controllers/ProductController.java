package com.projectJEE.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projectJEE.repositories.ProductRepository;
import com.projectJEE.tables.Product;

@Controller
public class ProductController {
	
	@Autowired 
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public String showProducts(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "products";
	}
	
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
	 @GetMapping("/{id}")
	 public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		 return productRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	*/
}
