package net.shopin.hmtpdamw.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.buffer.SimpleBufferAllocator;
import net.rubyeye.xmemcached.command.TextCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * 配置缓存--memcached
 * @author 刘金金
 *
 */
@Configuration
public class SpringContextConfig {
	@Autowired
	Environment env;
	
//	@Bean
//	public MemcachedClientBuilder memcachedClientBuilder() {
//		MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(
//				AddrUtil.getAddresses(env.getProperty("spring.memcache.service")),
//				new int[]{1, 1, 1});
//		memcachedClientBuilder.setConnectionPoolSize(50);
//		memcachedClientBuilder.setSessionLocator(new KetamaMemcachedSessionLocator());
//		memcachedClientBuilder.setTranscoder(new SerializingTranscoder());
//		memcachedClientBuilder.setCommandFactory(new TextCommandFactory());
//		memcachedClientBuilder.setBufferAllocator(new SimpleBufferAllocator());
//		
//		return memcachedClientBuilder;
//	}
//	@Bean(name="memcacheClient")
//	public MemcachedClient memcacheClient() {
//		MemcachedClient memcacheClient = null;
//		try {
//			memcacheClient = this.memcachedClientBuilder().build();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return memcacheClient;
//	}
	
	/**
	 * 设置编码utf-8
	 * 
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		List<MediaType> types = new ArrayList<MediaType>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("charset", "UTF-8");
		MediaType type = new MediaType("text", "plain", map);
		System.out.println("stringHttpMessageConverter --------------------------   "+type.getCharSet());
		types.add(type);
		converter.setSupportedMediaTypes(types);
		return converter;
	}
	
	
	
}

