package com.projectJEE;

import com.projectJEE.repositories.*;
import com.projectJEE.tables.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitializeDatabase {

	private static final Logger log = LoggerFactory.getLogger(InitializeDatabase.class);
	
	@Bean
	public CommandLineRunner loadData(ProductRepository productRepository, 
									  StockRepository stockRepository,
									  PlaceRepository placeRepository,
									  CategoryRepository categoryRepository,
									  EffectAndPreparationRepository effectAndPreparationRepository){
		
		return args -> {
	    	// PRODUCTS :
	    	if ( (productRepository.count()+stockRepository.count()+placeRepository.count()+categoryRepository.count()+effectAndPreparationRepository.count()) == 0) {
	    		Product pA = new Product("Cattails (pollen)",
						new ArrayList<>(Arrays.asList("Pu Huang", "Pollen Typhae", "Bulrush", "蒲黄")),
						ProductType.PLANT,
						"Pollen that can be used as a diuretic or to aid clotting ; it is collected in summer, directly from the flowers after being dried. Light smell or taste.",
						"");
				Product pB = new Product("Aloeswood",
						new ArrayList<>(Arrays.asList("Wood of Gods", "Agarwood", "Eaglewood", "Oudh")),
						ProductType.WOOD,
						"A quite luxury wood often used in incenses",
						"/img/productPics/Aloeswood.PNG");	
				Product pC = new Product("Horseradish ",
						new ArrayList<>(),
						ProductType.PLANT,
						"a root vegetable used worldwide as a spice and condiment, with a quite bitter flavor. If let undisturbed, it can grow invasive",
						"");
				Product pD = new Product("Ambergris ",
						new ArrayList<>(Arrays.asList("Dragon’s Saliva Incense", "Ambergrease", "Grey amber")),
						ProductType.ANIMAL_PART,
						"Its name also means “dragon’s saliva incense” as it is said to be made from a dragon’s drool. This waxy substance is used in perfume and is particulary expensive. Is effective to treat the heart and many other things.",
						"/img/productPics/Ambergris.PNG");
				Product pE = new Product("Wolfsbane ",
						new ArrayList<>(Arrays.asList("Monkshood", "Aconite", "Devil's helmet", "Blue Rocket")),
						ProductType.PLANT,
						"Easily mistaken with the Mugwort (safe one), Wolfsbane can be revieled to be quite poisonous according to the specific specie. They can be used to coat arrows for hunting or warfare.",
						"/img/productPics/Wolfsbane.PNG");
				productRepository.saveAll(List.of(pA,pB,pC,pD,pE));
						
				// STOCKS :	
				Stock sA = new Stock(3, new Dosage(40,"g"), 0.40f );
				Stock sB = new Stock(2, new Dosage(15,"pieces"), 6.50f );
				pA.setStock(sA);
				sA.setStockedProduct(pA);
				pB.setStock(sB);
				sB.setStockedProduct(pB);
				stockRepository.saveAll(List.of(sA,sB));
				
				// PLACES : 
				Place plA = new Place("River named A", 4, 8);
				Place plB = new Place("Woods named something something", 10, 2);
				placeRepository.saveAll(List.of(plA,plB));
				
				// CATEGORIES :
				Category cA = new Category("Antiemetic","A drug against vomiting and nausea, usually to treat motion sickness");
				Category cB = new Category("Diuretic","A drug that help remove salt and water of the body through urine");
				Category cC = new Category("Antipyretics ","An anti-unflammatory drugs, for example, to suppress/dull fevers");
				Category cD = new Category("Anxiolytics ","Medications that help reduce anxiety");
				categoryRepository.saveAll(List.of(cA,cB,cC,cD));
				
				// EFFECTS AND PREP :
				EffectAndPreparation eA = new EffectAndPreparation("Help regulating the blood ; Stop external bleeding",
																   "Unknown. Burn it, maybe.",
																   new Dosage(40,"g"),
																   4,
																   pA);
				effectAndPreparationRepository.save(eA);	    		
	    	}
	    };
	    }
	
	
}
