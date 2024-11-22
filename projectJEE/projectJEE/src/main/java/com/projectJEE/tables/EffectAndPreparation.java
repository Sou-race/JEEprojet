package com.projectJEE.tables;

import com.projectJEE.Dosage;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EffectAndPreparation {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String effectDescription;	
	
	private String preparationDescription;		
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "quantity", column = @Column(name = "dosage_quantity")),
		  @AttributeOverride( name = "unit", column = @Column(name = "dosage_unit"))
		})
	private Dosage dosage = new Dosage(0.0f, "g");	
	
	private float onsetOfActionInHour;	
	
	@ManyToOne
	private Product usedProduct;
	
	@ManyToOne
	private Category categoryOfThisEffect;

	
	

	public String getEffectDescription() {
		return effectDescription;
	}

	public void setEffectDescription(String description) {
		this.effectDescription = description;
	}

	public String getPreparationDescription() {
		return preparationDescription;
	}

	public void setPreparationDescription(String preparationDescription) {
		this.preparationDescription = preparationDescription;
	}

	public Dosage getDosage() {
		return dosage;
	}
	
	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}

	public float getOnsetOfActionInHour() {
		return onsetOfActionInHour;
	}

	public void setOnsetOfActionInHour(float onsetOfActionInHour) {
		this.onsetOfActionInHour = onsetOfActionInHour;
	}

	public Product getUsedProduct() {
		return usedProduct;
	}

	public void setUsedProduct(Product usedProduct) {
		this.usedProduct = usedProduct;
	}

	public Long getId() {
		return id;
	}
	

	public Category getCategoryOfThisEffect() {
		return categoryOfThisEffect;
	}

	public void setCategoryOfThisEffect(Category categoryOfThisEffect) {
		this.categoryOfThisEffect = categoryOfThisEffect;
	}
}
