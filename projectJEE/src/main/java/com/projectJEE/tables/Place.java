package com.projectJEE.tables;
import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Place {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String name="";
	
	private int latititude;
	
	private int longitude;
	
	/*Faut que je regarde comment ça marche les many to many, ça doit pas être bien compliqué
	 * @ManyToMany
	private Set<Product> produitDispo;
	*/
	public Place(String name, int latititude, int longitude) {
		this.name = name;
		this.latititude = latititude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLatititude() {
		return latititude;
	}

	public void setLatititude(int latititude) {
		this.latititude = latititude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
