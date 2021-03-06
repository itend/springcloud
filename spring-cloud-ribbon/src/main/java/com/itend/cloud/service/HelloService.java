package com.itend.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	@Autowired
	private RestTemplate restTemplate;

	public String sayHello(String name) {
		return restTemplate.getForObject("http://SERVICE-HELLOSERVICE/hello?name=" + name, String.class);
	}
}
