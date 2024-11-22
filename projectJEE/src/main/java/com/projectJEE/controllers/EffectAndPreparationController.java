package com.projectJEE.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectJEE.repositories.EffectAndPreparationRepository;
import com.projectJEE.tables.EffectAndPreparation;

@Controller
public class EffectAndPreparationController {
	
	@Autowired 
	EffectAndPreparationRepository effectAndPreparationRepository;
	
	@GetMapping("/effectsAndPreparations")
	public String showEffectsAndPreparations(Model model) {
		List<EffectAndPreparation> effectsAndPreparations = effectAndPreparationRepository.findAll();
		model.addAttribute("effectsAndPreparations", effectsAndPreparations);
		return "effectsAndPreparations";
	}
}

