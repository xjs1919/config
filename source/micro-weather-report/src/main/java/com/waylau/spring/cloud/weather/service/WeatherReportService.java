package com.waylau.spring.cloud.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waylau.spring.cloud.weather.vo.Weather;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月26日 下午7:40:14<br/>
 */
@Service
public class WeatherReportService {
	
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WeatherReportService.class);
	
	@Autowired
	WeatherDataService weatherDataService;
	
	public Weather getWeatherDataByCityId(String cityId) throws Exception{
		WeatherResponse response = weatherDataService.getDataByCityId(cityId);
		return response.getData();
	}
}
