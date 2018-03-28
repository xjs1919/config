package com.waylau.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
//http://localhost:8888/micro-weather-config-client/dev
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
