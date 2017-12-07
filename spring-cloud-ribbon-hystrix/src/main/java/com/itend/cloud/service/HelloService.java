package com.itend.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "sayHelloError")
	public String sayHello(String name) {
		return restTemplate.getForObject("http://service-helloservice/hello?name=" + name, String.class);
	}

	public String sayHelloError(String name) {
		return "hello, =" + name + ", service is busy!";
	}
}
