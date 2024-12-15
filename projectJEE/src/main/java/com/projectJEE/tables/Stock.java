package com.projectJEE.tables;

import com.projectJEE.Dosage;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "shelfNumber")})
public class Stock {
	public static final int MAX_SHELF_NUMBER = 15;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Min(value = 0, message = "This shelf number does not exist")
	@Max(value = MAX_SHELF_NUMBER, message = "This shelf number does not exist. (We need to buy more furnitures !!)")
	@OrderBy("shelfNumber ASC")
	@Column(nullable = false)
	private int shelfNumber;	
	
	@OneToOne
	private Product stockedProduct;
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "quantity", column = @Column(name = "dosage_quantity")),
		  @AttributeOverride( name = "unit", column = @Column(name = "dosage_unit"))
		})
	private Dosage dosage = new Dosage(0.0f, "g");	
	
	private Float pricePerUnit;
	
	public Stock() {}
	public Stock(
			@Min(value = 0, message = "This shelf number does not exist") @Max(value = 150, message = "This shelf number does not exist. (We need to buy more furnitures !!)") int shelfNumber,
			Dosage dosage, Float pricePerUnit) {
		this.shelfNumber = shelfNumber;
		this.dosage = dosage;
		this.pricePerUnit = pricePerUnit;
	}

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

	public Dosage getDosage() {
		return dosage;
	}

	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
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
