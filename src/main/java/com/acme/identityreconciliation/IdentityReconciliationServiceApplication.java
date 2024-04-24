package com.acme.identityreconciliation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IdentityReconciliationServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(IdentityReconciliationServiceApplication.class, args);
		System.out.println("Identity-Reconciliation");
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
