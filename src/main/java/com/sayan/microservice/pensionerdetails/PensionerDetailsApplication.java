package com.sayan.microservice.pensionerdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PensionerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailsApplication.class, args);
	}

}
