package com.projectJEE.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
public class Stock {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Min(value = 0, message = "This shelf number does not exist")
	@Max(value = 150, message = "This shelf number does not exist. (We need to buy more furnitures !!)")
	@OrderBy("shelfNumber ASC")
	private int shelfNumber;	
	
	@OneToOne
	private Product stockedProduct;
	
	private int quantity;
	
	private String unit = "g"; //en grammes par défaut
	
	private Float pricePerUnit;
	
	
	

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
	
	public Float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
}
