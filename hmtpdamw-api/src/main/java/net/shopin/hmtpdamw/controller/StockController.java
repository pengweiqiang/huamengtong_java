package net.shopin.hmtpdamw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shopin.hmtpdamw.apiresult.ApiPadResult;
import net.shopin.hmtpdamw.condition.BaseCondition;
import net.shopin.hmtpdamw.constants.InfoConstants.CodeInfo;

/**
 * 库存接口
 * @author pengweiqiang
 * @Date:2017年5月3日
 */
@RestController
@RequestMapping(value="/price")
public class StockController {
	
	@RequestMapping(value="/getStocks",produces="text/html;charset=UTF-8;application/json;charset=UTF-8")
	public ApiPadResult getStocks(BaseCondition cond,String parentCategorySid){
		
		
		return ApiPadResult.Y(CodeInfo.操作成功,true);
	}
}
