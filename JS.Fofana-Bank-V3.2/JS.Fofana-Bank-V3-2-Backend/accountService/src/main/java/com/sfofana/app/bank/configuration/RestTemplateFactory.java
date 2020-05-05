package com.sfofana.app.bank.configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory {

	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
//	public URL getUrl() {
//		URL url;
//		try {
//			url = new URL("");
//			return url;
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
