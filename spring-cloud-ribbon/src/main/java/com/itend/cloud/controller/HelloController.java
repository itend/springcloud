package com.itend.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itend.cloud.service.HelloService;

@RestController
public class HelloController {
	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/hello")
	public String sayHello(@RequestParam(value = "name") String name) {
		return helloService.sayHello(name);
	}
}
