package net.shopin.hmtpdamw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import net.shopin.hmtpdamw.apiresult.ApiPadResult;
import net.shopin.hmtpdamw.apiresult.ApiResultResponse;
import net.shopin.hmtpdamw.condition.BaseCondition;
import net.shopin.hmtpdamw.constants.Constants;
import net.shopin.hmtpdamw.constants.InfoConstants.CodeInfo;
import net.shopin.hmtpdamw.util.DateUtils;

/**
 * 登陆接口
 * @author pengweiqiang
 * @Date:2017年04月28日
 */
@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController{
		
	/**
	 * @Destription:用户登陆
	 * @param userName
	 * @param password
	 * @param macAddress
	 * @return
	 */
	@RequestMapping(value="/login/{userName}/{password}",produces="text/html;charset=UTF-8;application/json;charset=UTF-8")
	public ApiPadResult login(BaseCondition condition,@PathVariable("userName") String userName,@PathVariable("password") String password,String macAddress){
		try{
			logger.info(condition.toString()+" 用户名:"+userName+"  密码："+password);
			return ApiPadResult.Y(CodeInfo.操作成功,true);
		}catch(Exception e){
			e.printStackTrace();
			return ApiPadResult.N(CodeInfo.未知错误,e.getLocalizedMessage());
		}
	}
	
	/**
	 * @Destription:修改登录密码
	 * @param cond
	 * @param newPassword 新密码
	 * @return
	 */
	@RequestMapping(value="/updatePwd/{oldPassword}/{newPassword}",produces="text/html;charset=UTF-8;application/json;charset=UTF-8")
	public ApiPadResult updatePwd(BaseCondition cond,@PathVariable("oldPassword") String oldPassword,@PathVariable("newPassword") String newPassword){
		ApiPadResult apiPadResult = null;
		Map<String,Object> urlVariables = new HashMap<>();
		urlVariables.put("username", cond.getUserName());
		urlVariables.put("pwd", oldPassword);
		urlVariables.put("newPwd", newPassword);
		StringBuffer loginUrl = new StringBuffer(apiUrl.getLoginUrl()).append("/guideLogin/updatePasswordToPad/{username}/{pwd}/{newPwd}");
		RestTemplate restTemplate = new RestTemplate();
		String apiResultStr = restTemplate.getForObject(loginUrl.toString(), String.class,urlVariables);
		ApiResultResponse apiResult =JSON.parseObject(apiResultStr, ApiResultResponse.class);
		if(apiResult.isSuccess()){
			apiPadResult = ApiPadResult.Y(CodeInfo.操作成功,true);
		}else{
			apiPadResult = ApiPadResult.N(CodeInfo.密码修改失败,apiResult.getDesc());
		}
		
		return apiPadResult;
	}
}
