package com.sfofana.app.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sfofana.app.bank.model.Account;
import com.sfofana.app.bank.model.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	public List<Account> findByUser(User user);
}
