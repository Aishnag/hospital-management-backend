package com.hms.doclogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="medicines")
public class Medicine {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(name = "drug_Name")
	private String drugName;
	private String stock;
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine(long id, String drugName, String stock) {
		super();
		Id = id;
		this.drugName = drugName;
		this.stock = stock;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}


}
