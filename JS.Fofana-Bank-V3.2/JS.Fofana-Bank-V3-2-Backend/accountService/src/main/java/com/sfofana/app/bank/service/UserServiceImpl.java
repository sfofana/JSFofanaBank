package com.sfofana.app.bank.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.sfofana.app.bank.configuration.RestTemplateFactory;
import com.sfofana.app.bank.exception.BusinessException;
import com.sfofana.app.bank.model.Account;
import com.sfofana.app.bank.model.User;
import com.sfofana.app.bank.repository.AccountRepository;
import com.sfofana.app.bank.repository.UserRepository;
import com.sfofana.app.bank.utility.JsonUtility;

@Service
public class UserServiceImpl implements UserService {

	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	AccountRepository accountRepo;
	@Autowired
	RestTemplateFactory restTemplate;
	@Autowired
	JsonUtility jsonUtil;
	
	@Value("${depositUrl}")
	private String depositUrl;
	@Value("${withdrawUrl}")
	private String withdrawUrl;
	@Value("${transferUrl}")
	private String transferUrl;
	
	@Override
	public User getUser(User user) throws BusinessException {
		HttpEntity<Object> request = new HttpEntity<Object>(user);
		User deposit = restTemplate.getRestTemplate()
				.postForObject(depositUrl, request, User.class);
		User withdraw = restTemplate.getRestTemplate()
				.postForObject(withdrawUrl, request, User.class);
		User transfer = restTemplate.getRestTemplate()
				.postForObject(transferUrl, request, User.class);
		
		List<Account> accounts = user.getAccounts();
		accounts.forEach(account -> {
			double currentAmount = account.getAmount();
			
			double depositAmt = deposit.getAccounts().stream()
					.filter(acct -> acct.getId() == account.getId())
					.collect(Collectors.toList()).get(0).getAmount();
			
			double withdrawAmt = withdraw.getAccounts().stream()
					.filter(acct -> acct.getId() == account.getId())
					.collect(Collectors.toList()).get(0).getAmount();
			
			double transferAmt = transfer.getAccounts().stream()
					.filter(acct -> acct.getId() == account.getId())
					.collect(Collectors.toList()).get(0).getAmount();
			
			double newAmount = depositAmt + withdrawAmt + transferAmt;
			account.setAmount(currentAmount + newAmount);
		});
		user.setAccounts(accounts);
		return user;
	}

	@Override
	public User getUsingHttp() throws BusinessException {
		URL url = null;
		User object = null;
		String json = null;
		String user = "sfofana";
		String pass = "UofH2011";
		String auth = user + ":" + pass;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
		String authValue = "Basic " + new String(encodedAuth);
		try {
			url = new URL("http://localhost:9001/api/v1/user");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection connection = null;
		try {		
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", authValue);
			InputStream in = connection.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			StringBuilder response = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				response.append(line);
			}
			json = response.toString();
			object = jsonUtil.jsonStringToObject(json, User.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return object;
	}
}
