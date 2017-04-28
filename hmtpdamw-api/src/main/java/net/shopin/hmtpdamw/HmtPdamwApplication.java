package net.shopin.hmtpdamw;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import net.shopin.hmtpdamw.config.ApiUrlConfig;


/**
 * 程序入口
 * @author pengweiqiang
 *
 */
@SpringBootApplication
@EnableScheduling //定时任务
@MapperScan("net.shopin.hmtpdamw.presistence.*")//扫描mapp.xml文件
@ServletComponentScan//可能会用到 Servlet、Filter、Listener、Interceptor 等等。
@EnableConfigurationProperties(ApiUrlConfig.class)
//@EnableTransactionManagement//启用注解式事务管理
public class HmtPdamwApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return super.configure(builder);
	}
	
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
       FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
       FastJsonConfig fastJsonConfig = new FastJsonConfig();
       fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
       fastJsonConfig.setCharset(StandardCharsets.UTF_8);
       fastConverter.setFastJsonConfig(fastJsonConfig);
       return new HttpMessageConverters(fastConverter);
    }
	
	/**
	 * 设置编码utf-8
	 * 
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		List<MediaType> types = new ArrayList<MediaType>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("charset", "UTF-8");
		MediaType type = new MediaType("text", "plain", map);
//		System.out.println("stringHttpMessageConverter    "+type.getCharSet());
		types.add(type);
		converter.setSupportedMediaTypes(types);
		return converter;
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HmtPdamwApplication.class, args);
	}
}
