package com.sfofana.app.bank.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sfofana.app.bank.model.Account;
import com.sfofana.app.bank.model.User;
import com.sfofana.app.bank.repository.AccountRepository;
import com.sfofana.app.bank.repository.UserRepository;

@Component
public class StubData implements CommandLineRunner{

	@Autowired
	UserRepository userRepo;
	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(
				1, 
				"5e98e708caf2bf4d70a1dc25",
				"Amir",
				"Kamara",
				"master@gmail.com",
				"demo",
				null
				);				
		userRepo.save(u1);
		
		User u2 = new User(
				2,
				"5e98e78dcaf2bf4d70a1dc26",
				"System",
				"Admin",
				"system@gmail.com",
				"admin",
				null
				);	
		userRepo.save(u2);
		
		Account a1 = new Account(
				1001,
				"saving",
				0,
				u1
				);
		accountRepo.save(a1);
		
		Account a2 = new Account(
				1002,
				"checking",
				0,
				u1
				);
		accountRepo.save(a2);
		
		Account a3 = new Account(
				1003,
				"saving",
				0,
				u1
				);
		accountRepo.save(a3);	
		
		Account a4 = new Account(
				1004,
				"checking",
				0,
				u1
				);
		accountRepo.save(a4);
		
		Account a5 = new Account(
				1005,
				"checking",
				0,
				u2
				);
		accountRepo.save(a5);
		
		Account a6 = new Account(
				1006,
				"saving",
				0,
				u2
				);
		accountRepo.save(a6);
		
	}

}
