package com.sfofana.app.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfofana.app.bank.exception.BusinessException;
import com.sfofana.app.bank.model.Account;
import com.sfofana.app.bank.model.User;
import com.sfofana.app.bank.repository.AccountRepository;
import com.sfofana.app.bank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	AccountRepository accountRepo;

	@Override
	public User authenticate(User user) throws BusinessException {
		User valid = userRepo.findByEmail(user.getEmail());

		if (valid == null) {
			throw new BusinessException("user not found");
		} else if (valid.getEmail().equals(user.getEmail()) && 
				valid.getPassword().equals(user.getPassword())) {
			List<Account> accounts = accountRepo.findByUser(valid);
			valid.setAccounts(accounts);
			return valid;
		} else {
			throw new BusinessException("user not found");
		}
	}

	@Override
	public List<User> getUsers() throws BusinessException {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser() throws BusinessException {
		User user = userRepo.findById(1).get();
		List<Account> accounts = accountRepo.findByUser(user);
		user.setAccounts(accounts);
		return user;
	}
}
