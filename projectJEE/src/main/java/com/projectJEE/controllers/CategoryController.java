package com.projectJEE.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectJEE.repositories.CategoryRepository;
import com.projectJEE.tables.Category;

@Controller
public class CategoryController {
	
	@Autowired 
	CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
	public String showProducts(Model model) {
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "categories";
	}
}
