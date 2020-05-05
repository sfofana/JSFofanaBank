package com.sfofana.app.bank.service;

import java.util.List;

import com.sfofana.app.bank.exception.BusinessException;
import com.sfofana.app.bank.model.User;

public interface UserService {

	public User authenticate(User user) throws BusinessException;
	public List<User> getUsers() throws BusinessException;
	public User getUser() throws BusinessException;
}
