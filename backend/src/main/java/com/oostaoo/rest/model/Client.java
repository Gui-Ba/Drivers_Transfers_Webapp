package com.oostaoo.rest.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
public class Client {
	@Id
	private String id;
	private String nom;
	private String prenom;
	@DBRef
	private List<Transfer> transfer;
	
		



	public Client() {
	}

	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		
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
	
	
	public List<Transfer> getTransfer() {
		return transfer;
	}

	public void setTransfer(List<Transfer> transfer) {
		this.transfer = transfer;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", transfer=" + transfer + "]";
	}


	
	
	 
}

