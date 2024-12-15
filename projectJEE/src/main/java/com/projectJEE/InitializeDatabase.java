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
						"/img/productPics/Cattails.PNG");
				Product pB = new Product("Aloeswood",
						new ArrayList<>(Arrays.asList("Wood of Gods", "Agarwood", "Eaglewood", "Oudh")),
						ProductType.WOOD,
						"A quite luxury wood often used in incenses",
						"/img/productPics/Aloeswood.PNG");	
				Product pC = new Product("Horseradish",
						new ArrayList<>(Arrays.asList("Armoracia rusticana")),
						ProductType.PLANT,
						"a root vegetable used worldwide as a spice and condiment, with a quite bitter flavor. If let undisturbed, it can grow invasive",
						"/img/productPics/Horseradish.PNG");
				Product pD = new Product("Ambergris",
						new ArrayList<>(Arrays.asList("Dragon’s Saliva Incense", "Ambergrease", "Grey amber")),
						ProductType.ANIMAL_PART,
						"Its name also means “dragon’s saliva incense” as it is said to be made from a dragon’s drool. This waxy substance is used in perfume and is particulary expensive. Is effective to treat the heart and many other things.",
						"/img/productPics/Ambergris.PNG");
				Product pE = new Product("Wolfsbane",
						new ArrayList<>(Arrays.asList("Monkshood", "Aconite", "Devil's helmet", "Blue Rocket")),
						ProductType.PLANT,
						"Easily mistaken with the Mugwort (safe one), Wolfsbane can be revieled to be quite poisonous according to the specific specie. They can be used to coat arrows for hunting or warfare.",
						"/img/productPics/Wolfsbane.PNG");
				Product pF = new Product("Henbane",
						new ArrayList<>(Arrays.asList("Black Henbane", "Stinking Nightshade")),
						ProductType.PLANT,
						"The leaves, the seeds and the juice, when taken internally cause an unquiet sleep, like unto the sleep of drunkenness, which continueth long and is deadly to the patient. Henbane is also used in traditional herbal medicine.",
						"/img/productPics/Henbane.PNG");
				Product pG = new Product("Belladonna",
						new ArrayList<>(Arrays.asList("Deadly Nightshade", "Atropa Bella-donna", "Belladone")),
						ProductType.PLANT,
						"Can be used in medicine. But a high dosage can cause hallucinations, spasms, etc. During the Victorian and Renaissance eras, actresses would use it as eye drops to dilate their pupils, making their eyes appear bigger.",
						"/img/productPics/Belladonna.PNG");	
				Product pH = new Product("Mugwort",
						new ArrayList<>(Arrays.asList("Ngai Chou", "艾草", "yomogi")),
						ProductType.PLANT,
						"Mugwort has seen continuous use in many cultures throughout the world as a medicinal, spiritual, and culinary ingredient since at least the Iron Age. In contemporary culture mugwort is commonly found in foods and drinks.",
						"/img/productPics/Mugwort.PNG");	
				productRepository.saveAll(List.of(pA,pB,pC,pD,pE,pF,pG,pH));
						
				// STOCKS :	
				Stock sA = new Stock(3, new Dosage(40,"g"), 0.40f );
				Stock sB = new Stock(2, new Dosage(15,"pieces"), 6.50f );
				Stock sC = new Stock(5, new Dosage(23,"petals"), 13.75f );
				pA.setStock(sA);
				sA.setStockedProduct(pA);
				pB.setStock(sB);
				sB.setStockedProduct(pB);
				pG.setStock(sC);
				sC.setStockedProduct(pG);
				stockRepository.saveAll(List.of(sA,sB,sC));
				
				// PLACES : 
				Place plA = new Place("River named A", 4, 8);
				Place plB = new Place("Woods named something something", 10, 2);
				placeRepository.saveAll(List.of(plA,plB));
				
				// CATEGORIES :
				Category cA = new Category("Antiemetic","A drug against vomiting and nausea, usually to treat motion sickness");
				Category cB = new Category("Diuretic","A drug that help remove salt and water of the body through urine");
				Category cC = new Category("Antipyretic","An anti-unflammatory drugs, for example, to suppress/dull fevers");
				Category cD = new Category("Anxiolytics","Medications that help reduce anxiety");
				Category cE = new Category("Mycotoxin","Toxins produced by certain molds (fungi) and that can be found in food");
				Category cF = new Category("Moxibustion","A traditional Chinese medicine therapy which consists of burning dried mugwort (moxa) on particular points on the body. Is an alternative to acupuncture");
				Category cG = new Category("Anaesthetic ","A substance that induces insensitivity to pain.");
				Category cH = new Category("Hallucinogen","A drug that causes hallucinations");
				Category cI = new Category("Abortifacient","A substance that induces abortion.");
				categoryRepository.saveAll(List.of(cA,cB,cC,cD,cE,cF,cG,cH,cI));
				 
				
				// EFFECTS AND PREP :
				EffectAndPreparation eA = new EffectAndPreparation("Help regulating the blood ; Stop external bleeding",
																   "Unknown. Burn it, maybe.",
																   new Dosage(40,"g"),
																   4,
																   pA);
				eA.setCategoryOfThisEffect(cB);
				EffectAndPreparation eB = new EffectAndPreparation("For powerfull visual hallucinations and a sensation of flight - may lead to death.",
										   "Can be combined with Belladonna, Datura or Mandrake",
										   new Dosage(10,"mL"),
										   2,
										   pF);
				eB.setCategoryOfThisEffect(cH);
				EffectAndPreparation eC = new EffectAndPreparation("It is believed to enhance healing with acupuncture. Its purpose is to strengthen the blood, stimulate the flow of Qi or energy, and maintain good health.",
						   "The Mugwort leaves must be burnt close to the skin’s surface using a stick to apply heat.",
						   new Dosage(7,"leaves"),
						   0,
						   pH);
				eC.setCategoryOfThisEffect(cF);
				EffectAndPreparation eD = new EffectAndPreparation("Used to prevent pregnancy. Must NOT use for people with a history of uterine inflammation or recent pelvic infections.",
						   "10 to 14 days prior to menstruation, drink four to six times a day of tea infusion. It is important to not take Mugwort for longer than six days.",
						   new Dosage(60,"tsp"),
						   0,
						   pH);
				eD.setCategoryOfThisEffect(cI);
				effectAndPreparationRepository.saveAll(List.of(eA,eB,eC,eD));		
	    	}
	    };
	    }
	
	
}

