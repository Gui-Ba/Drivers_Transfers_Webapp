package com.oostaoo.rest.model;


import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "drivers")
public class Driver {
	@Id
	private String id;
	private String nom;
	private String prenom;
	private int experience;
	private String voiture;
	private boolean active;
	@DBRef
	private List<Transfer> transfer;
	  
	 


	public Driver() {
	}


	public Driver(String nom, String prenom, int experience, String voiture) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.experience = experience;
		this.voiture = voiture;
	}


	
	
	public List<Transfer> getTransfer() {
		return transfer;
	}


	public void setTransfer(List<Transfer> transfer) {
		this.transfer = transfer;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getVoiture() {
		return voiture;
	}
	
	public void setVoiture(String voiture) {
		this.voiture = voiture;
	}

	public int getAge() {
		return experience;
	}

	public void setAge(int experience) {
		this.experience = experience;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}




}

