package com.security.controller;

import java.security.Principal;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.repository.UserRepository;

@RestController
public class UserController
{
	
	@Autowired
	UserRepository r;
	
	@GetMapping("/")
	public String home() {
		return "(<h1>welcome</h1>)";
	}
	
	@GetMapping("/user")
	public String user(Principal p) {
		User user = r.findByUserName(p.getName()).get();
		return "Hello " + user.getUserName()+" <h1>welcome admin </h1>";
	}
	
	@GetMapping("/admin")
	public String admin (User user) {
		return user.getUserName()+"(<h1>welcome admin </h1>)";
	}
}
