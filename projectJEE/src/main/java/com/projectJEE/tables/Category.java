package com.projectJEE.tables;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String title;	
	
	private String definition;	
	
	@OneToMany(mappedBy = "categoryOfThisEffect",fetch = FetchType.EAGER)
	private List<EffectAndPreparation> myEffectsAnfPreparations = new ArrayList<>();

	
	
	public Category() {}
	public Category(String title, String definition) {
		super();
		this.title = title;
		this.definition = definition;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public List<EffectAndPreparation> getMyEffectsAnfPreparations() {
		return myEffectsAnfPreparations;
	}

	public void setMyEffectsAnfPreparations(List<EffectAndPreparation> myEffectsAnfPreparations) {
		this.myEffectsAnfPreparations = myEffectsAnfPreparations;
	}

	public Long getId() {
		return id;
	}
}
