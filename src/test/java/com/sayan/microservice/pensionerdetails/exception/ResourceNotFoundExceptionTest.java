package com.sayan.microservice.pensionerdetails.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sayan.microservice.pensionerdetails.PensionerDetailsApplication;


@SpringBootTest(classes = PensionerDetailsApplication.class)
public class ResourceNotFoundExceptionTest {

	@Test
	void testResourceNotFoundException() {
		Object ex1 = new ResourceNotFoundException("Message");
		Object ex2 = new ResourceNotFoundException();
		assertNotNull(ex1);
		assertNotNull(ex2);
	}
}
