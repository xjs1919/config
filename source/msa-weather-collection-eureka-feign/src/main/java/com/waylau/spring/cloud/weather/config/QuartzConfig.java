package com.waylau.spring.cloud.weather.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.waylau.spring.cloud.weather.job.WeatherDataSyncJob;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午1:15:56<br/>
 */
@Configuration
public class QuartzConfig {
	
	//JobDetail:定义一个特定的job
	//Trigger： 定义触发的时机
	@Bean
	public JobDetail weatherDataSyncJobDetail() {
		return JobBuilder.newJob(WeatherDataSyncJob.class)
									.withIdentity("weatherDataSyncJobDetail")
									.storeDurably()
									.build();
	}
	
	@Bean
	public Trigger weatherDataSyncJobTrigger() {
		SimpleScheduleBuilder builder = SimpleScheduleBuilder
				.simpleSchedule()
				.withIntervalInSeconds(1800)
				.repeatForever();
		return TriggerBuilder.newTrigger()
					.forJob(weatherDataSyncJobDetail())
					.withIdentity("weatherDataSyncJobTrigger")
					.withSchedule(builder)
					.build();
	}
	
}
