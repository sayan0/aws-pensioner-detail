package com.sayan.microservice.pensionerdetails.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayan.microservice.pensionerdetails.bean.PensionDetailsBean;
import com.sayan.microservice.pensionerdetails.exception.ResourceNotFoundException;
import com.sayan.microservice.pensionerdetails.exception.UnAuthorizedRequestException;
import com.sayan.microservice.pensionerdetails.proxy.AuthProxy;
import com.sayan.microservice.pensionerdetails.repository.PensionRepository;

@RestController
@CrossOrigin(origins = "*")
public class PensionDetailsController {

	@Autowired
	private PensionRepository pensionRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(PensionDetailsController.class);
	
	@Autowired
	private AuthProxy authProxy;
	
	
	@GetMapping("/PensionerDetailByAadhaar/{aadharno}")
	@ResponseBody
	public ResponseEntity<PensionDetailsBean> pensionDetails(@RequestHeader("Authorization") final String idToken, @PathVariable String aadharno)
			throws ResourceNotFoundException,UnAuthorizedRequestException {
		
			Boolean isAuthorized = authProxy.onAuthorization(idToken).getBody();
			
			if(isAuthorized) {
				PensionDetailsBean pension = pensionRepository.findById(aadharno).orElseThrow(()->new ResourceNotFoundException("Aadhar number not found"));
				logger.info("Pension info provided");
				return new ResponseEntity<>(pension, HttpStatus.OK);
			}
			else {
				logger.info("Not Authorized");
				throw new UnAuthorizedRequestException("Not Authorized");
			}
	}
}
