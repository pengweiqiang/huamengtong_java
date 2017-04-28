package net.shopin.hmtpdamw.apiresult;

import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.shopin.jiaxing.rest.framework.api.BaseEntity;
import net.shopin.hmtpdamw.constants.Constants;

public class BodyResponse<T extends BaseEntity> extends JSONObject{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7702888899492704381L;

	public  T getEntity(Class<T> clazz){
		String entity = getString(Constants.ENTITY);
		if(StringUtils.isEmpty(entity) || "{}".equals(entity)){
			return null;
		}
		return JSON.parseObject(entity, clazz);
	}
	
	
	public List<T> getList(Class<T> clazz){
		return JSON.parseArray(getJSONObject(Constants.PAGE).getString(Constants.LIST), clazz);
	}
	
	public <T> T getPageEntity(Class<T> clazz){
		return (T)JSON.parseObject(getString(Constants.PAGE),clazz);
	}
	
//	public  PagePadEntity getPageEntity2(){
//		JSON.parseObject(this.getString(Constants.PAGE),)
//	}
	
}
