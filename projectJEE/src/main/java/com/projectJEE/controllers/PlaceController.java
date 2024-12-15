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
    private PlaceRepository placeRepository;

    @GetMapping("/places")
    public String showPlaces(Model model) {
        model.addAttribute("places", placeRepository.findAllByOrderByName());
        return "places";
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

