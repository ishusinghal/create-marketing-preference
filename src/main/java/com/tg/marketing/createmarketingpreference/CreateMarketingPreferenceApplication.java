package com.tg.marketing.createmarketingpreference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CreateMarketingPreferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateMarketingPreferenceApplication.class, args);
	}

}
