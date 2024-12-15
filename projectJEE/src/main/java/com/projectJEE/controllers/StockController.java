package com.projectJEE.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectJEE.repositories.StockRepository;
import com.projectJEE.tables.Stock;

@Controller
public class StockController {
	
	@Autowired 
	StockRepository stockRepository;
	
	@GetMapping("/stocks")
	public String showStockByOrder(Model model) {
		List<Stock> stocks = stockRepository.findAllByOrderByStockedProduct();		
		model.addAttribute("stocks", stocks);
		return "stocks";
	}
	

}
