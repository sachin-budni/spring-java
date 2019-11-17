package com.org.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.services.HelloService;

@Controller
public class HelloController {

	//@Autowired
	private HelloService helloService;
	
	@Autowired
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@RequestMapping("/messages/{id}")
	@ResponseBody
	public String sayHello(@PathVariable int id) {
		return helloService.getMessageOne(id);
	}
	
//	@RequestMapping("/sachin")
//	@ResponseBody
//	public String getSachinMessage() {
//		return helloService.getMessageTwo();
//	}
//	
//	@RequestMapping("/google")
//	@ResponseBody
//	public String getGoogleMessage() {
//		return helloService.getMessageThree();
//	}
}
