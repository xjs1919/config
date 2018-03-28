package com.waylau.spring.cloud.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午7:39:37<br/>
 */
@FeignClient(name="msa-weather-eureka-client-zuul")
public interface DataClient {
	
	@GetMapping("/city/cities")
	List<City> cities();
	
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId);
}
