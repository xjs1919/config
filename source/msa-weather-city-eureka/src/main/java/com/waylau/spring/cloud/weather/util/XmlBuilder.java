package com.waylau.spring.cloud.weather.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年3月27日 下午1:32:57<br/>
 */
public class XmlBuilder {
	
	public static <T> T xmlToBean(String xml, Class<T> clazz) throws Exception{
		JAXBContext context = JAXBContext.newInstance(clazz);
		// XML 转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(xml);
		@SuppressWarnings("unchecked")
		T t = (T)unmarshaller.unmarshal(reader);
		if (null != reader) {
			reader.close();
		}
		return t;
	}
	
}
