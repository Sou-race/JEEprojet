package com.projectJEE;

import jakarta.persistence.Embeddable;

@Embeddable
public class Dosage {
	
	private float quantity;	
	private String unit;
	
	public Dosage() {
	}
	public Dosage(float k, String v) {
		this.quantity = k;
		this.unit = v;
	}
	
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float key) {
		this.quantity = key;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String value) {
		this.unit = value;
	}
}
