package com.sayan.microservice.pensionerdetails;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PensionerDetailsApplicationTests {
	
	@Autowired
	private PensionerDetailsApplication application;

	@Test
	void contextLoads() throws Exception{
		PensionerDetailsApplication.main(new String[] {});
		assertNotNull(application);
	}

}
