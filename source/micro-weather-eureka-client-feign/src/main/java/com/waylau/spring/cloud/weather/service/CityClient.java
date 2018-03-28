package com.waylau.spring.cloud.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午5:14:01<br/>
 */
@FeignClient("msa-weather-city-eureka")
public interface 	CityClient {
	
	@GetMapping("/cities")
	public String listCity();
	
}
