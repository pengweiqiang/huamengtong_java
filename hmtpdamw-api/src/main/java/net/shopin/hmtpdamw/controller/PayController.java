package net.shopin.hmtpdamw.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shopin.hmtpdamw.apiresult.ApiPadResult;
import net.shopin.hmtpdamw.condition.BaseCondition;
import net.shopin.hmtpdamw.constants.InfoConstants.CodeInfo;

/**
 * 支付接口
 * @author pengweiqiang
 * @Date:2017年5月3日
 */
@RestController
@RequestMapping(value="/pay")
public class PayController {
	
	@RequestMapping(value="/pay",produces="text/html;charset=UTF-8;application/json;charset=UTF-8")
	public ApiPadResult pay(BaseCondition cond,@PathVariable("mobile") String mobile){
		
		
		return ApiPadResult.Y(CodeInfo.查询成功,true);
	}
}
