package com.quick.cache;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * spring test
 * @author gerry.zhang
 *
 */
@ContextConfiguration(locations="classpath:cache/applicationContext-ehcache.xml")
public class EhcacheTest extends AbstractJUnit4SpringContextTests{
	
	private static final Logger log = LoggerFactory.getLogger(EhcacheTest.class);
	
	private static final String CACHE_NAME = "demoCache";
	
	@Autowired
	private CacheManager cacheManager;
	
	private Cache cache;
	
	@Test
	public void demo(){
		cache = cacheManager.getCache(CACHE_NAME);

		String key = "foo";
		String value = "boo";

		put(key, value);
		Object result = get(key);
		log.info(result.toString());
		
	}
	
	
	public Object get(String key){
		Element element = cache.get(key);
		return element.getObjectValue();
	}
	
	public void put(String key,Object obj){
		Element element = new Element(key, obj);
		cache.put(element);
	}
	
	
	
	
	

}
