package com.projectJEE.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
