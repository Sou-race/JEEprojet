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
	
	@Override
	public void run(ApplicationArguments args) throws Exception{	
		
		//TestStart_AdingThreeObjects();
		
		/*
		Stock testStock = new Stock();
		testStock.setQuantity(80);
		testStock.setUnit("piece(s)");
		testStock.setShelfNumber(7);
		Stock testStockB = new Stock();
		testStockB.setQuantity(0);
		testStockB.setUnit("Kg");
		testStockB.setShelfNumber(2);		
		
		stockRepository.save(testStock);
		stockRepository.save(testStockB);
		*/
		
	}
	
	public void TestStart_AdingThreeObjects() {
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
		testStock.setQuantity(40);
		testStock.setUnit("g");
		testStock.setShelfNumber(3);
		
		//Comme c'est Stock qui a l'id du Produit, faut save produit avant sinon explosion
		productRepository.save(testProduit);
		productRepository.save(testProduitB);		
			
		testProduit.setStock(testStock);
		testStock.setStockedProduct(testProduit);
				
		stockRepository.save(testStock);
	}
	
}
