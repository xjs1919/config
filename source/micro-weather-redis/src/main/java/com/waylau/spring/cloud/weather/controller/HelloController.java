package com.waylau.spring.cloud.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 605162215@qq.com
 *
 * 
 * http://wthrcdn.etouch.cn/weather_mini?city=%E5%8C%97%E4%BA%AC
 * http://wthrcdn.etouch.cn/weather_mini?citykey=101280601
 * http://mobile.weather.com.cn/js/citylist.xml
 */
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello,world";
	}
	
}	
