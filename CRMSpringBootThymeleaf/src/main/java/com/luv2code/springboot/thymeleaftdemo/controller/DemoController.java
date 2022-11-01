package com.luv2code.springboot.thymeleaftdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/hello")
	public String helloWorld(Model model) {
		System.out.println("Inside hello world");
		model.addAttribute("theDate", new java.util.Date());
		
		return "helloworld";
		
	}
	
}
