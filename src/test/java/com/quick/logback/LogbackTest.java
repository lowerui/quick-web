package com.quick.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackTest {
	private static final Logger log = LoggerFactory.getLogger(LogbackTest.class); 
	public static void main(String[] args) {
		
		log.info("测试info");
		log.debug("测试debug");

	}

}
