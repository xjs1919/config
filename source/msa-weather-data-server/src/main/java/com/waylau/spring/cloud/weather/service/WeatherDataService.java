package com.waylau.spring.cloud.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月26日 下午7:40:14<br/>
 */
@Service
public class WeatherDataService {
	
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WeatherDataService.class);
	
	private static String uri = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	StringRedisTemplate redisTemplate;
	
	
	public WeatherResponse getDataByCityId(String cityId)throws Exception {
		return get(uri+"citykey="+cityId);
	}
	
	public WeatherResponse getDataByCityName(String cityName) throws Exception{
		return get(uri+"city="+cityName);
	}
	
	private WeatherResponse get(String url)throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ValueOperations<String, String>  op= (ValueOperations<String, String>)redisTemplate.opsForValue();
		String str = op.get(url);
		if(str == null || str.length() <= 0) {
			throw new RuntimeException("缓存数据为空");
		}
		return  mapper.readValue(str, WeatherResponse.class);
	}
}
