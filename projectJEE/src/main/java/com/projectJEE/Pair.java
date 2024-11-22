package com.projectJEE;

import jakarta.persistence.Embeddable;

@Embeddable
public class Pair {
	
	private float key;	
	private String value;
	
	public Pair() {
	}
	public Pair(float k, String v) {
		this.key = k;
		this.value = v;
	}
	
	public float getKey() {
		return key;
	}
	public void setKey(float key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
