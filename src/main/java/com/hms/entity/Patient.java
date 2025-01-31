package com.hms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String first_name;
	@Column(name = "blood_group")
	private String blood;
	private String age;
	private String prescipstion;
	private String dose;
	private String fees;
	private String urgency;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPrescipstion() {
		return prescipstion;
	}

	public void setPrescipstion(String prescipstion) {
		this.prescipstion = prescipstion;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public Patient(long id, String first_name, String blood, String age, String prescipstion, String dose, String fees,
			String urgency) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.blood = blood;
		this.age = age;
		this.prescipstion = prescipstion;
		this.dose = dose;
		this.fees = fees;
		this.urgency = urgency;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

}
