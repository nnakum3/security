package com.security;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
public class SecurityApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
