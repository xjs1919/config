package com.waylau.spring.cloud.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.waylau.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午6:43:30<br/>
 */
@FeignClient(name="msa-weather-data-eureka")
public interface WeatherDataClient {
	
	@GetMapping("/weather/cityId/{cityId}")
	public WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId)throws Exception ;
	
}
