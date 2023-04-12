package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	
	@GetMapping("/response")
	public String responsePage() {
		return "response";
	}
}
