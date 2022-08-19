package com.sayan.microservice.pensionerdetails.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sayan.microservice.pensionerdetails.bean.PensionDetailsBean;
import com.sayan.microservice.pensionerdetails.proxy.AuthProxy;
import com.sayan.microservice.pensionerdetails.repository.PensionRepository;


@WebMvcTest(PensionDetailsController.class)

public class PensionDetailsControllerTest {

	@MockBean
	private PensionRepository repository;
	@MockBean
	private AuthProxy authProxy;
	@Autowired
	private MockMvc mockMvc;
	
	private static final Logger logger = LoggerFactory.getLogger(PensionDetailsControllerTest.class);
	
	@Test
    void test_displayPensionerDetail() throws Exception {
        Optional<PensionDetailsBean> optionalPensioner = Optional.ofNullable(new PensionDetailsBean());
        String token = "cnxlcdj)*DS)qiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJSYW11MSIsImV4cCI6MTY1NzQyMzgxOSwiaWF0IjoxNjU3NDIyMDE5fQ.NxKTNWIWxerx1YacDzWZnpwVkXCO65fLthl8lQCQnyMozBvGjY9BEvHAsEbikkLwOnRmOoyuvowxDEI6HxoaQg";
        ResponseEntity<Boolean> authResp = new ResponseEntity<>(true, HttpStatus.OK);

        when(this.repository.findById(anyString())).thenReturn(optionalPensioner);
        when(this.authProxy.onAuthorization(token)).thenReturn(authResp);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/PensionerDetailByAadhaar/{aadhaarNumber}", "123456789001")
                .header("Authorization", token))
                .andExpect(MockMvcResultMatchers.status().isOk());
        logger.info(token);
    }

    @Test
    void test_displayPensionerDetail_if_unauthorized() throws Exception {
        Optional<PensionDetailsBean> optionalPensioner = Optional.ofNullable(new PensionDetailsBean());
        String token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJSYW11MSIsImV4cCI6MTY1NzQyMzgxOSwiaWF0IjoxNjU3NDIyMDE5fQ.NxKTNWIWxerx1YacDzWZnpwVkXCO65fLthl8lQCQnyMozBvGjY9BEvHAsEbikkLwOnRmOoyuvowxDEI6HxoaQg";
        ResponseEntity<Boolean> authResp = new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);

        when(this.repository.findById(anyString())).thenReturn(optionalPensioner);
        when(this.authProxy.onAuthorization(token)).thenReturn(authResp);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/PensionerDetailByAadhaar/{aadharno}", "123456789000")
                .header("Authorization", token))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    void test_displayPensionerDetail_for_resourcenotfound_exception() throws Exception {
        Optional<PensionDetailsBean> optionalPensioner = Optional.ofNullable(null);
        String token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJSYW11MSIsImV4cCI6MTY1NzQyMzgxOSwiaWF0IjoxNjU3NDIyMDE5fQ.NxKTNWIWxerx1YacDzWZnpwVkXCO65fLthl8lQCQnyMozBvGjY9BEvHAsEbikkLwOnRmOoyuvowxDEI6HxoaQg";
        ResponseEntity<Boolean> authResp = new ResponseEntity<>(true, HttpStatus.OK);

        when(this.repository.findById(anyString())).thenReturn(optionalPensioner);
        when(this.authProxy.onAuthorization(token)).thenReturn(authResp);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/PensionerDetailByAadhaar/{aadhaarNumber}", "123456789000")
                .header("Authorization", token))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void test_displayPensionerDetail_for_feign_exception() throws Exception {
        Optional<PensionDetailsBean> optionalPensioner = Optional.ofNullable(null);
        String token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJSYW11MSIsImV4cCI6MTY1NzQyMzgxOSwiaWF0IjoxNjU3NDIyMDE5fQ.NxKTNWIWxerx1YacDzWZnpwVkXCO65fLthl8lQCQnyMozBvGjY9BEvHAsEbikkLwOnRmOoyuvowxDEI6HxoaQg";

        when(this.repository.findById(anyString())).thenReturn(optionalPensioner);
        when(this.authProxy.onAuthorization(token)).thenReturn(new ResponseEntity<>(false, HttpStatus.OK) );

        this.mockMvc.perform(MockMvcRequestBuilders.get("/PensionerDetailByAadhaar/{aadhaarNumber}", "123456789000")
                .header("Authorization", token))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

    }
	
}
