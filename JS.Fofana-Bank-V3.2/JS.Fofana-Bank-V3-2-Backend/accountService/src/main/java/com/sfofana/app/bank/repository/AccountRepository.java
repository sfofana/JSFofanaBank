package com.sfofana.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sfofana.app.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
