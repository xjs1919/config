package com.waylau.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.waylau.spring.cloud.weather.service.CityDataService;
import com.waylau.spring.cloud.weather.service.WeatherReportService;

/**
 * @author 605162215@qq.com
 *
 * 
 * http://wthrcdn.etouch.cn/weather_mini?city=%E5%8C%97%E4%BA%AC
 * http://wthrcdn.etouch.cn/weather_mini?citykey=101280601
 * http://mobile.weather.com.cn/js/citylist.xml
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	@Autowired
	WeatherReportService reportService;
	
	@Autowired
	CityDataService cityDataService;
	
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView cityId(@PathVariable("cityId") String cityId, Model model)throws Exception {
		model.addAttribute("title","天气预报");
		model.addAttribute("cityId",cityId);
		model.addAttribute("cityList",cityDataService.listCities());
		model.addAttribute("report",reportService.getWeatherDataByCityId(cityId));
		return 	new ModelAndView("weather/report", "reportModel", model);
	}
	
}	
