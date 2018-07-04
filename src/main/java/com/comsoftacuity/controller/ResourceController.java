package com.comsoftacuity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {

	/*@ResponseBody
	@GetMapping("/home")
	public List<String> homePage() {
		return Arrays.asList("Joseph" , "Edache" , "Peter");
	}*/
	
	@GetMapping("/home")
	public String homePage() {
		return "index.html";
	}
}
