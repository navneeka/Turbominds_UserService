package com.ibm.accountmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("swagger-ui.html");
		return "redirect:swagger-ui.html";
	}
}
