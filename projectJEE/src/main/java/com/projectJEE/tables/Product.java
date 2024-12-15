package com.projectJEE.tables;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String name = "";
	
	private List<String> otherNames = new ArrayList<>();
	
	private ProductType type;
	
	private String description;	
	
	private String picLink;
	
	@OneToOne(mappedBy = "stockedProduct", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Stock stock;	
	
	@OneToMany(mappedBy = "usedProduct",fetch = FetchType.EAGER)
	private List<EffectAndPreparation> possibleEffectsAnfPreparations = new ArrayList<>();
	
	@ManyToMany(mappedBy = "dispoProduct", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Place> places;
	

	public Product() {}
	public Product(String name, List<String> otherNames, ProductType type, String description, String picLink) {
		super();
		this.name = name;
		this.otherNames = otherNames;
		this.type = type;
		this.description = description;
		this.picLink = picLink;
		this.places = new HashSet<>();
	}
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(List<String> otherNames) {
		this.otherNames = otherNames;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
		if (stock != null && stock.getStockedProduct() != this) {
	        stock.setStockedProduct(this);
	    }
	}
	
	public List<EffectAndPreparation> getPossibleEffectsAnfPreparations() {
		return possibleEffectsAnfPreparations;
	}

	public void setPossibleEffectsAnfPreparations(List<EffectAndPreparation> possibleEffectsAnfPreparations) {
		this.possibleEffectsAnfPreparations = possibleEffectsAnfPreparations;
	}

	public Set<Place> getPlaces() {
		return this.places;
	}
	
}
