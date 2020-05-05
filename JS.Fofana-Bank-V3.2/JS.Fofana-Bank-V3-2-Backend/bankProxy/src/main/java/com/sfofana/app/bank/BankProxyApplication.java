package com.sfofana.app.bank;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class BankProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankProxyApplication.class, args);
	}
	
	@Bean
	@Primary
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = 
				new UrlBasedCorsConfigurationSource();
		final CorsConfiguration configuration = 
				new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedOrigin("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", configuration);
		return new CorsFilter();
	}
}
