package com.waylau.spring.cloud.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月28日 下午1:42:07<br/>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Value("${auther.name}")
	String name;
	
	@Test
	public void testConfig() {
		assertEquals(name, "xjs");
	}
	
}
