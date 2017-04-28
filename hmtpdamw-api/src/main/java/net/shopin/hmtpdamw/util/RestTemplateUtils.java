package net.shopin.hmtpdamw.util;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

public class RestTemplateUtils {

	public static RestTemplate getRestTemplateUTF_8() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new SourceHttpMessageConverter<>());
		messageConverters.add(new FormHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static HttpEntity<String> getRestTemplate(String cartUrl, JSONObject param) {
		return getRestTemplate(getRestTemplate(), cartUrl, param);
	}

	public static HttpEntity<String> getRestTemplate(RestTemplate restTemplate, String cartUrl, JSONObject param) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		// headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(param, headers);
		HttpEntity<String> response = restTemplate.exchange(cartUrl, HttpMethod.POST, entity, String.class);// 这里放JSONObject,
																											// String
																											// 都可以。因为JSONObject返回的时候其实也就是string
		return response;
	}

	public static RestTemplate getRestTemplateAddConverter() {
		RestTemplate restTemplate = new RestTemplate();
		FormHttpMessageConverter fc = new FormHttpMessageConverter();
		StringHttpMessageConverter s = new StringHttpMessageConverter(StandardCharsets.UTF_8);
		List<HttpMessageConverter<?>> partConverters = new ArrayList<HttpMessageConverter<?>>();

		partConverters.add(s);
		partConverters.add(new ResourceHttpMessageConverter());
		fc.setPartConverters(partConverters);
		restTemplate.setMessageConverters(Arrays.asList(fc, new MappingJackson2HttpMessageConverter()));
		return restTemplate;
	}
}
