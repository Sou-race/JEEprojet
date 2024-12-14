package com.projectJEE.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectJEE.repositories.PlaceRepository;
import com.projectJEE.tables.Place;

@Controller
public class PlaceController {

	@Autowired 
	PlaceRepository placeRepository;
	
	@GetMapping("/places")
	public String showPlacesById(Model model) {
		List<Place> places = placeRepository.findAllByOrderByName();
		model.addAttribute("places", places);
		return "places";
	}
}
