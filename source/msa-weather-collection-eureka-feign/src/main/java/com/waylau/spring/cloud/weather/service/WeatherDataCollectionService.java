package com.waylau.spring.cloud.weather.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午2:25:25<br/>
 * 
 * 天气数据采集服务
 */
@Service
public class WeatherDataCollectionService {
	
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WeatherDataCollectionService.class);
	
	private static String uri = "http://wthrcdn.etouch.cn/weather_mini?";
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	StringRedisTemplate redisTemplate;
	
	public void syncWeatherDataByCityId(String cityId) {
		String url = uri+"citykey="+cityId;
		saveWeatherDataToRedis(url);
	}
	
	public void saveWeatherDataToRedis(String url) {
		ValueOperations<String, String>  op= (ValueOperations<String, String>)redisTemplate.opsForValue();
		ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		if(result.getStatusCode()==HttpStatus.OK) {
			//写入到缓存
			op.set(url, result.getBody(), 1800, TimeUnit.SECONDS);
		}
	}
	
}	
