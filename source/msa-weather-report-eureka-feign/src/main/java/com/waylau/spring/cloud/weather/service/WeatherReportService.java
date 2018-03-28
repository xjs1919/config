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
	WeatherDataClient dataClient;
	
	public Weather getWeatherDataByCityId(String cityId) throws Exception{
		WeatherResponse resposne = dataClient.getDataByCityId(cityId);
		return resposne.getData();
		//TODO 由天气数据API微服务来提供
//		Weather weather  = new Weather();
//		weather.setAqi("1212");
//		weather.setCity("广州");
//		weather.setGanmao("注意感冒");
//		weather.setWendu("温度0读");
//		List<Forecast> forecast = new ArrayList<Forecast>();
//		Forecast f = new Forecast();
//		f.setDate("2018-03-27");
//		f.setFengli("风力");
//		f.setFengxiang("风向");
//		f.setHigh("20");
//		f.setLow("0");
//		f.setType("type");
//		forecast.add(f);
//		weather.setForecast(forecast);
//		return weather;
	}
}
