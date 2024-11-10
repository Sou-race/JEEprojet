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
		
		//Test ajout d'un product et son étagère :		
		
		Product testProduit = new Product();
		testProduit.setName("Cattails (pollen)");
		testProduit.setOtherNames(new ArrayList<>(Arrays.asList("Pu Huang", "Pollen Typhae", "Bulrush", "蒲黄")));
		testProduit.setDescription("Pollen that can be used as a diuretic or to aid clotting ; it is collected in summer, directly from the flowers after being dried. Light smell or taste.");
		testProduit.setType(ProductType.PLANT);		

		Stock testStock = new Stock();
		testStock.setQuantity(40);
		testStock.setUnit("g");
		testStock.setShelfNumber(3);
		
		//Comme c'est Product qui a l'id du Stock, faut save stock avant sinon explosion
		stockRepository.save(testStock);
		
		testProduit.setStock(testStock);
	    testStock.setStockedProduct(testProduit);
		
		productRepository.save(testProduit);
		
		
	}
	
}
