package com.waylau.spring.cloud.weather.job;

import java.util.ArrayList;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import com.waylau.spring.cloud.weather.service.WeatherDataCollectionService;
import com.waylau.spring.cloud.weather.vo.City;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午1:14:23<br/>
 */
@Service
public class WeatherDataSyncJob extends QuartzJobBean {

	private static Logger log = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Autowired
	WeatherDataCollectionService weatherDataCollectionService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		log.debug("WeatherDataSyncJob start");
//		List<City> citys = cityDataService.listCities();
		List<City> citys = new ArrayList<City>();
		City c = new City();
		c.setCityId("101280101");
		c.setCityName("广州");
		citys.add(c);
		for(City city : citys) {
			log.debug("city:"+city.getCityName());
			weatherDataCollectionService.syncWeatherDataByCityId(city.getCityId());
		}
		log.debug("WeatherDataSyncJob end");
	}
}
