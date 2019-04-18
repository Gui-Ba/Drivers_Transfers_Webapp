package com.oostaoo.rest.model;

import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transferts")
public class Transfer {
	@Id
	private String id;
	private int numeroT;
	private Client client;
	private Date date;
	private int distance;
	private String VDepart;
	private String VArrive;
	private int price;
	private Driver driver;
	private boolean active;
	
	
	
	
	public Transfer() {
		super();
	}



	public Transfer(int numeroT, Date date, String vDepart, String vArrive, int distance, int price,  boolean active) {
		super();
		this.numeroT = numeroT;
		this.date = date;
		this.distance = distance;
		VDepart = vDepart;
		VArrive = vArrive;
		this.price = price;
		this.active = active;
	}



	public Transfer( Driver driver, Client client, int distance, Date date ) {
		super();
		this.date = date;
		this.distance = distance;
		this.driver = driver;
		this.client = client;
	}
	
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getVDepart() {
		return VDepart;
	}


	public void setVDepart(String vDepart) {
		VDepart = vDepart;
	}


	public String getVArrive() {
		return VArrive;
	}


	public void setVArrive(String vArrive) {
		VArrive = vArrive;
	}


	public int getNumeroT() {
		return numeroT;
	}


	public void setNumeroT(int numeroT) {
		this.numeroT = numeroT;
	}
	
	
	 
}

