package com.waylau.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.spring.cloud.weather.service.WeatherDataService;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * 
 * http://wthrcdn.etouch.cn/weather_mini?city=%E5%8C%97%E4%BA%AC
 * http://wthrcdn.etouch.cn/weather_mini?citykey=101280601
 * http://mobile.weather.com.cn/js/citylist.xml
 */
@RestController
public class WeatherController {
	
	@Autowired
	WeatherDataService dataService;
	
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse cityId(@PathVariable("cityId") String cityId)throws Exception {
		return dataService.getDataByCityId(cityId);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse cityName(@PathVariable("cityName") String cityName) throws Exception{
		return dataService.getDataByCityName(cityName);
	}
}	
