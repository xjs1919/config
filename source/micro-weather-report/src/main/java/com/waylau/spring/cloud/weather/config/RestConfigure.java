package com.waylau.spring.cloud.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月26日 下午7:50:26<br/>
 */
@Configuration
public class RestConfigure {
	
	@Autowired
	RestTemplateBuilder builder;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return builder.build();
	}
	
}
