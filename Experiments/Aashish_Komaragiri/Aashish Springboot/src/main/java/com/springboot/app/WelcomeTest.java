package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeTest {

	//Hello world springboot example
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to spring boot";
	}
	
	
}
