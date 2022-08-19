package com.sayan.microservice.pensionerdetails.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth", url = "${AUTH_MICROSERVICE_URI:http://localhost:4000}")
public interface AuthProxy {
	
	    @GetMapping("/authorize")
	    public ResponseEntity<Boolean> onAuthorization(@RequestHeader("Authorization") String token);
	
}