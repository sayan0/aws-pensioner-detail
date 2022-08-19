package com.sayan.microservice.pensionerdetails.bean;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

import com.sayan.microservice.pensionerdetails.PensionerDetailsApplication;

@SpringBootTest(classes = PensionerDetailsApplication.class)
public class PensionDetailsBeanTest {

	@Test
	void testBean() throws Exception {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(PensionDetailsBean.class);
//		String arr[] = null;
//		PensionDetailsBean bean = new PensionDetailsBean(arr);
//		assertNotNull(bean);
	}
}
