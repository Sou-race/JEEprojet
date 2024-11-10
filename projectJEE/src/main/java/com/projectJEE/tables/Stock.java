package com.projectJEE.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Stock {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	private int shelfNumber;
	
	@OneToOne(mappedBy = "stock")
	private Product stockedProduct;
	
	private int quantity;
	
	private String unit = "g"; //en grammes par défaut
	
	
	
	public int getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}
	
	public Product getStockedProduct() {
		return stockedProduct;
	}

	public void setStockedProduct(Product stockedProduct) {
		this.stockedProduct = stockedProduct;
		if (stockedProduct != null && stockedProduct.getStock() != this) {
			stockedProduct.setStock(this);
	    }
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}
	
}
