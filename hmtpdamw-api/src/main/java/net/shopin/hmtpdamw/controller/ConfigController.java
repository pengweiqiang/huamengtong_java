package net.shopin.hmtpdamw.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shopin.hmtpdamw.apiresult.ApiPadResult;
import net.shopin.hmtpdamw.condition.BaseCondition;
import net.shopin.hmtpdamw.constants.InfoConstants.CodeInfo;

/**
 * 相关配置选择API
 * 省份、城市、开户行等
 * @author pengweiqiang
 * @Date:2017年5月3日
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
	
	/**
	 * @Destription:获取省份列表
	 * @param cond
	 * @return
	 */
	@RequestMapping(value="/getProvinces",produces="text/html;charset=UTF-8;application/json;charset=UTF-8")
	public ApiPadResult getProvinces(BaseCondition cond){
		
		
		return ApiPadResult.Y(CodeInfo.查询成功,true);
	}
	/**
	 * 
	 * @Destription:通过省份id获取城市列表
	 * @param cond
	 * @param pid 省份id
	 * @return
	 */
	@RequestMapping(value="/getCitysByPid/{pid}",produces="text/html;charset=UTF-8;application/json;charset=UTF-8")
	public ApiPadResult getCitysByPid(BaseCondition cond,@PathVariable("pid") String pid){
		
		
		return ApiPadResult.Y(CodeInfo.查询成功,true);
	}
	
	/**
	 * 
	 * @Destription:获取开户行
	 * @param cond
	 * @return
	 */
	@RequestMapping(value="/getBanks",produces="text/html;charset=UTF-8;application/json;charset=UTF-8")
	public ApiPadResult getBanks(BaseCondition cond){
		
		
		return ApiPadResult.Y(CodeInfo.查询成功,true);
	}
	
}
