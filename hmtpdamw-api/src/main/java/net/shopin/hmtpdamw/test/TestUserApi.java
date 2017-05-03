package net.shopin.hmtpdamw.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * 用户测试类
 * @author pengweiqiang
 *
 */
public class TestUserApi {
	@Test
	public void login(){
		String url = "http://localhost:8080/hmtpdamw";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "J0100001");
		map.put("password", "0001super");
		RestTemplate rt = new RestTemplate();
		StringBuffer sbUrl = new StringBuffer(url).append("/user/login/{userName}/{password}");
		sbUrl.append("?ipAddress=172.16.101.216&appVersionName=V1.0.0&macAddress=123123");
		System.out.println(sbUrl);
		String str = rt.postForObject(sbUrl.toString(), null, String.class, map);
		System.out.println(str);
	}
	
	@Test
	public void updatePwd(){
		String url = "http://localhost:8080/hmtpdamw";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oldPassword", "0001");
		map.put("newPassword", "0001");
		RestTemplate rt = new RestTemplate();
		StringBuffer sbUrl = new StringBuffer(url).append("/user/updatePwd/{oldPassword}/{newPassword}");
		sbUrl.append("?userName=J00001&password=123&ipAddress=172.16.101.216&appVersionName=V1.0.0&shopSid=1001&optUserSid=123&macAddress=123");
		System.out.println(sbUrl);
		String str = rt.postForObject(sbUrl.toString(), null, String.class, map);
		System.out.println(str);
	}
}
