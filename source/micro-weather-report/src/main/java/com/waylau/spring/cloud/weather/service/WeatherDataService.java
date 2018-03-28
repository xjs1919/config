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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月26日 下午7:40:14<br/>
 */
@Service
public class WeatherDataService {
	
	private static Logger log = LoggerFactory.getLogger(WeatherDataService.class);
	
	private static String uri = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	StringRedisTemplate redisTemplate;
	
	
	public WeatherResponse getDataByCityId(String cityId)throws Exception {
		return get(uri+"citykey="+cityId);
	}
	
	public WeatherResponse getDataByCityName(String cityName) throws Exception{
		return get(uri+"city="+cityName);
	}
	
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
	
	private WeatherResponse get(String url)throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse resp  = null;
		ValueOperations<String, String>  op= (ValueOperations<String, String>)redisTemplate.opsForValue();
		if(redisTemplate.hasKey(url)) {//读取缓存
			log.debug("read from cache");
			String str = op.get(url);
			resp  = mapper.readValue(str, WeatherResponse.class);
		}else {
			log.debug("read from network");
			ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
			if(result.getStatusCode()==HttpStatus.OK) {
				resp  = mapper.readValue(result.getBody(), WeatherResponse.class);
				//写入到缓存
				op.set(url, result.getBody(), 1800, TimeUnit.SECONDS);
			}
		}
		return resp;
	}
}
