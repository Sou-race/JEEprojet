package com.projectJEE.tables;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToMany;


@Entity
public class Place {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String name;
	
	private int latitude;
	
	private int longitude;

	@ManyToMany
	@JoinTable(
	    name = "place_product", 
	    joinColumns = @JoinColumn(name = "place_id"),
	    inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private Set<Product> dispoProduct;
	
	public Place() {}
	public Place(String name, int latitude, int longitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dispoProduct = new HashSet<>();
	}

	public Set<Product> getDispoProduct() {
		return dispoProduct;
	}

	public void setDispoProduct(Set<Product> dispoProduct) {
		this.dispoProduct = dispoProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public Long getId() {
		return id;
	}
}
