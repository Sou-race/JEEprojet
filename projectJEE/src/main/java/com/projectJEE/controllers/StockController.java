package com.projectJEE.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/stocks/add")
    public String addStock(@RequestParam Long id) {
        stockRepository.findById(id).ifPresent(stock -> {
            if (stock.getDosage() != null) {
                stock.getDosage().setQuantity(stock.getDosage().getQuantity() + 1);
                stockRepository.save(stock);
            }
        });
        return "redirect:/stocks";
    }

    @PostMapping("/stocks/remove")
    public String removeStock(@RequestParam Long id) {
        stockRepository.findById(id).ifPresent(stock -> {
            if (stock.getDosage() != null && stock.getDosage().getQuantity() > 0) {
                stock.getDosage().setQuantity(stock.getDosage().getQuantity() - 1);
                stockRepository.save(stock);
            }
        });
        return "redirect:/stocks";
    }
}