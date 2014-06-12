package com.quick.core.mapper;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.springframework.stereotype.Component;

import com.quick.web.util.DateFormat;

/**
 * Object-JSON转换器
 * 解决springmvc 返回json数据Date类型显示为时间戳问题
 * 需配合<mvc:message-converters>使用
 * @author gerry.zhang
 * @version 1.0
 * @date 2014-6-9
 *
 */
@Component("objectJSONMapper")
public class ObjectJSONMapper extends ObjectMapper{
	
	
	public ObjectJSONMapper(){
		CustomSerializerFactory factory = new CustomSerializerFactory();  
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){  
			@Override
			public void serialize(Date value, JsonGenerator jsonGenerator,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {	
				jsonGenerator.writeString(DateFormat.formatString(value, "yyyy-MM-dd"));
			}  
        });  
        this.setSerializerFactory(factory);  
	}
	
	

}
