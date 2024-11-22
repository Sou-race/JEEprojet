package com.projectJEE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projectJEE.repositories.PlaceRepository;

@Controller
public class PlaceController {

	@Autowired 
	PlaceRepository placeRepository;
}
