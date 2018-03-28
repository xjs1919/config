package com.waylau.spring.cloud.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.spring.cloud.weather.service.CityDataService;
import com.waylau.spring.cloud.weather.vo.City;

/**
 * @author 605162215@qq.com
 *
 * 
 * http://wthrcdn.etouch.cn/weather_mini?city=%E5%8C%97%E4%BA%AC
 * http://wthrcdn.etouch.cn/weather_mini?citykey=101280601
 * http://mobile.weather.com.cn/js/citylist.xml
 */
@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	CityDataService cityDataService;
	
	@GetMapping("")
	public List<City> hello() {
		return cityDataService.listCities();
	}
	
}	
