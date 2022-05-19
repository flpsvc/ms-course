package com.springms.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springms.hroauth.entities.User;
import com.springms.hroauth.feignclients.UserFeignClients;

@Service
public class UserService {
	
	private static Logger Logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClients userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		
		if(user == null) {
			Logger.error("E-mail not found" + email);
			throw new IllegalArgumentException("Email not found");
		}
		Logger.info("e-mail found: "+ email);
		return user;
	}
	
	
}
