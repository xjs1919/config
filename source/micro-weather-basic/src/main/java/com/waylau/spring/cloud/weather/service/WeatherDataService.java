package com.waylau.spring.cloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月26日 下午7:40:14<br/>
 */
@Service
public class WeatherDataService {
	
	private static String uri = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	RestTemplate restTemplate;
	
	public WeatherResponse getDataByCityId(String cityId)throws Exception {
		ResponseEntity<String> result = restTemplate.getForEntity(uri+"citykey="+cityId, String.class);
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse resp  = null;
		if(result.getStatusCode()==HttpStatus.OK) {
			resp  = mapper.readValue(result.getBody(), WeatherResponse.class);
		}
		return resp;
	}
	
	public WeatherResponse getDataByCityName(String cityName) throws Exception{
		ResponseEntity<String> result = restTemplate.getForEntity(uri+"city="+cityName, String.class);
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse resp  = null;
		if(result.getStatusCode()==HttpStatus.OK) {
			resp  = mapper.readValue(result.getBody(), WeatherResponse.class);
		}
		return resp;
	}
	
}
