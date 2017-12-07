package com.itend.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itend.cloud.service.SchedualServiceHello.SchedualServiceHelloHystric;

@FeignClient(value = "service-helloservice", fallback = SchedualServiceHelloHystric.class)
public interface SchedualServiceHello {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String sayHelloFromFeignClient(@RequestParam(value = "name") String name);

	@Component
	class SchedualServiceHelloHystric implements SchedualServiceHello {

		@Override
		public String sayHelloFromFeignClient(String name) {
			return "sorry, service is busy!";
		}

	}
}
