package com.sayan.microservice.pensionerdetails.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.sayan.microservice.pensionerdetails.PensionerDetailsApplication;

@SpringBootTest(classes = PensionerDetailsApplication.class)
public class ExceptionResponseTest {
	
	@Test
	void testResourceNotFoundException() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ExceptionResponse.class);
		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.OK, null);
		assertNotNull(exceptionResponse);
	}
}
