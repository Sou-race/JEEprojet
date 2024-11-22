package com.projectJEE;

import com.projectJEE.repositories.*;
import com.projectJEE.tables.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectJeeApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjectJeeApplication.class, args);
	}
	
	
	@Autowired 
	ProductRepository productRepository;	
	@Autowired 
	StockRepository stockRepository;
	@Autowired 
	EffectAndPreparationRepository effectAndPreparationRepository;
	@Autowired 
	CategoryRepository categoryRepository;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception{		
		//TestStart_AddingThreeObjects();		
	}
	
	public void TestStart_AddingThreeObjects() {
		//Test ajout d'un product et son étagère :		
		Product testProduit = new Product();
		testProduit.setName("Cattails (pollen)");
		testProduit.setOtherNames(new ArrayList<>(Arrays.asList("Pu Huang", "Pollen Typhae", "Bulrush", "蒲黄")));
		testProduit.setDescription("Pollen that can be used as a diuretic or to aid clotting ; it is collected in summer, directly from the flowers after being dried. Light smell or taste.");
		testProduit.setType(ProductType.PLANT);		
				
		Product testProduitB = new Product();
		testProduitB.setName("Aloeswood");
		testProduitB.setOtherNames(new ArrayList<>(Arrays.asList("Wood of Gods", "Agarwood", "eaglewood", "oudh")));
		testProduitB.setDescription("A quite luxury wood often used in incenses");
		testProduitB.setType(ProductType.WOOD);	

		Stock testStock = new Stock();
		testStock.setDosage(new Dosage(40,"g"));
		testStock.setShelfNumber(3);
		
		//Comme c'est Stock qui a l'id du Produit, faut save produit avant sinon explosion
		productRepository.save(testProduit);
		productRepository.save(testProduitB);		
			
		testProduit.setStock(testStock);
		testStock.setStockedProduct(testProduit);				
		stockRepository.save(testStock);
		
		Stock testStockA = new Stock();
		testStockA.setDosage(new Dosage(80,"piece"));
		testStockA.setShelfNumber(7);
		Stock testStockB = new Stock();
		testStockB.setDosage(new Dosage(0.3f,"Kg"));
		testStockB.setShelfNumber(2);		
		
		stockRepository.save(testStockA);
		stockRepository.save(testStockB);
		
		Category c = new Category();
		c.setTitle("Antiemetic");
		c.setDefinition("A drug against vomiting and nausea, usually to treat motion sickness");
		categoryRepository.save(c);		
		Category c1 = new Category();
		c1.setTitle("Diuretic ");
		c1.setDefinition("A drug that help remove salt and water of the body through urine");
		categoryRepository.save(c1);	
		
		EffectAndPreparation e = new EffectAndPreparation();
		e.setEffectDescription("Help regulating the blood ; Stop external bleeding");
		e.setPreparationDescription("Unknown. Burn it, maybe.");
		e.setOnsetOfActionInHour(2);
		e.setDosage(new Dosage(40,"g"));
		e.setUsedProduct(testProduit);
		effectAndPreparationRepository.save(e);
		
		
		}
	
}
