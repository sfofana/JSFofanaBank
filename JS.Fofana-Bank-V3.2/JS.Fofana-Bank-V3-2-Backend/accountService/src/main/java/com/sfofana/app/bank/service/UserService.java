package com.sfofana.app.bank.service;

import com.sfofana.app.bank.exception.BusinessException;
import com.sfofana.app.bank.model.User;

public interface UserService {

	public User getUser(User user) throws BusinessException;
	public User getUsingHttp() throws BusinessException;
}
