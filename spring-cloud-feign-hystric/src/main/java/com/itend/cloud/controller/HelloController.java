package com.itend.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itend.cloud.service.SchedualServiceHello;

@RestController
public class HelloController {

	@Autowired
	private SchedualServiceHello schedualServiceHello;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sqyHello(String name) {
		return schedualServiceHello.sayHelloFromFeignClient(name);
	}
}
