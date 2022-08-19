package com.sayan.microservice.pensionerdetails.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sayan.microservice.pensionerdetails.PensionerDetailsApplication;


@SpringBootTest(classes = PensionerDetailsApplication.class)
public class UnAuthorizedRequestExceptionTest {
	
	@Test
	void test() {
		Object ex1 = new UnAuthorizedRequestException("Message");
		Object ex2 = new UnAuthorizedRequestException();
		assertNotNull(ex1);
		assertNotNull(ex2);
	}
}
