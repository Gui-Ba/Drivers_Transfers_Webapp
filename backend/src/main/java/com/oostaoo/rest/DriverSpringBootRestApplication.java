package com.oostaoo.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oostaoo.rest.model.Client;
import com.oostaoo.rest.model.Driver;
import com.oostaoo.rest.model.Transfer;
import com.oostaoo.rest.repo.ClientRepository;
import com.oostaoo.rest.repo.DriverRepository;
import com.oostaoo.rest.repo.TransferRepository;


@SpringBootApplication
public class DriverSpringBootRestApplication implements CommandLineRunner {
		
	
	public static void main(String[] args) {
		SpringApplication.run(DriverSpringBootRestApplication.class, args);
	}

	@Autowired
	DriverRepository driverrepo;
	
	@Autowired
	ClientRepository clientrepo;
	
	@Autowired
	TransferRepository transferrepo;
	
	 @Override
	  public void run(String... args)  {
		 System.out.println("Hello From MyCommandLineRunner");
		
		 
		 Client client1 = new Client("Client1", "Client1");
		 Client client2 = new Client("Client2", "Client2");
		 Client client3 = new Client("Client3", "Client3");
		 clientrepo.insert(client3);
		 
		 Driver driver1= new Driver("driver1", "driver1", 20, "FIAT");
		 Driver driver2= new Driver("driver2", "driver2", 30 , "FIAT");
		 Driver driver3= new Driver("driver3", "driver3", 30 , "FIAT");
		 driverrepo.insert(driver3);
		 
		 
		 Calendar cal = GregorianCalendar.getInstance();
			cal.set(2019, Calendar.APRIL, 18, 10, 20, 00);
			cal.set(Calendar.MILLISECOND, 0);
			Date dateT = cal.getTime();
		 
		 Transfer transfer1= new Transfer(01,dateT, "PARIS", "MARSEILLE", 800, 222, false);
		 Transfer transfer2= new Transfer(02,dateT,"LILLE", "MARSEILLE", 1000,555, false);
		 Transfer transfer3= new Transfer(03,dateT,"PARIS", "BORDEAUX",600,234, false);
		 Transfer transfer4= new Transfer(04,dateT,"LYON", "BORDEAUX",600,333, false);

	

//		 
//		 List<Transfer> transfers= new ArrayList<Transfer>();
//		 transfers.add(transfer1);
//		 transfers.add(transfer2);
//		 transferrepo.insert(transfers);
		 
		 transferrepo.insert(transfer1);
		 transferrepo.insert(transfer2);
		 transferrepo.insert(transfer3);
		 transferrepo.insert(transfer4);

		 
		 List<Transfer> C1transfer = new ArrayList<Transfer>(); 
		 C1transfer.add(transfer1);
		 C1transfer.add(transfer2);
		 client1.setTransfer(C1transfer);
		 
		 List<Transfer> C2transfer = new ArrayList<Transfer>(); 
		 C2transfer.add(transfer3);
		 C2transfer.add(transfer4);
		 client2.setTransfer(C2transfer);
		 
		 
		 
		 		 
		 List<Transfer> D1transfer = new ArrayList<Transfer>();
		 D1transfer.add(transfer3);
		 D1transfer.add(transfer4);
		 driver1.setTransfer(D1transfer);
		 
		 	
	
		 List<Client> clients= new ArrayList<Client>();
		 clients.add(client2);
		 clients.add(client1);
		 
		 
		 List<Driver> drivers= new ArrayList<Driver>();
		 drivers.add(driver2);
		 drivers.add(driver1);
		 
//		 
//		 clientrepo.save(client2);		 
		 clientrepo.insert(clients);
//		 driverrepo.save(driver1);
		 driverrepo.insert(drivers);
		 
		 
		 


		 

		 
	 }
}

