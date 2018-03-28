package com.waylau.spring.cloud.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月26日 下午7:08:31<br/>
 */
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello,world";
	}
	
}	
