package com.waylau.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.waylau.spring.cloud.weather.vo.City;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午6:43:30<br/>
 */
@FeignClient(name="msa-weather-city-eureka")
public interface CityClient {
	
	@GetMapping("/cities")
	public List<City> cities();
}
