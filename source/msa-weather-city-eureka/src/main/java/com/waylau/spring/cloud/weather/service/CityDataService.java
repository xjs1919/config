package com.waylau.spring.cloud.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.waylau.spring.cloud.weather.util.XmlBuilder;
import com.waylau.spring.cloud.weather.vo.City;
import com.waylau.spring.cloud.weather.vo.CityList;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午1:35:28<br/>
 */
@Service
public class CityDataService {
	
	public List<City> listCities()  {
		try {
			Resource res = new ClassPathResource("citylist.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(res.getInputStream(), "UTF-8"));
			String line = "";
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			CityList cityList = XmlBuilder.xmlToBean(sb.toString(), CityList.class);
			return cityList.getCityList();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
