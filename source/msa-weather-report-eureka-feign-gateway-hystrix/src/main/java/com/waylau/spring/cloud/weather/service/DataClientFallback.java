package com.waylau.spring.cloud.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月28日 下午3:43:10<br/>
 */
@Service
public class DataClientFallback implements DataClient {
	
	@Override
	public List<City> cities(){
		List<City> citys = new ArrayList<City>();
		return citys;
	}
	
	@Override
	public WeatherResponse getWeatherDataByCityId(String cityId) {
		return null;
	}
}
