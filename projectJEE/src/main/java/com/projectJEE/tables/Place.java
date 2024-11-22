package com.projectJEE.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
