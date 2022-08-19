package com.sayan.microservice.pensionerdetails.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.microservice.pensionerdetails.bean.PensionDetailsBean;
import com.sayan.microservice.pensionerdetails.repository.PensionRepository;

@Service
public class PensionInitService {
	
	@Autowired
	private PensionRepository pensionRepository;
	
	private List<PensionDetailsBean> pensioners = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(PensionInitService.class);
	
	@PostConstruct
	public void loadDetails() throws ParseException {

		try  {
			
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("pension.csv");
		    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        
			String line;
		    while ((line = br.readLine()) != null) {
		    	logger.info(line);
		    	String pen[] = line.split(",");
		    	pensioners.add(new PensionDetailsBean(pen));
		    	
		    }
		}
		catch (IOException e1) {
			logger.info("IO Exception");
		   e1.printStackTrace();
			  }
		
		pensionRepository.saveAll(pensioners);
		logger.info("Loading Done");
		
	}
	
	
}
