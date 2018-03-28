package com.waylau.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.waylau.spring.cloud.weather.service.CityClient;
/**
 * Hello Controller.
 * 
 * @since 1.0.0 2017年11月20日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
public class HelloController {
	
	@Autowired
	CityClient cityClient;
	
	//@RequestMapping("/hello")
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/cities")
	@HystrixCommand(fallbackMethod="defaultCity")
	public String cities() {
		return cityClient.listCity();
	}
	
	public String defaultCity() {
		return "城市服务宕机，请稍后重试";
	}
}
