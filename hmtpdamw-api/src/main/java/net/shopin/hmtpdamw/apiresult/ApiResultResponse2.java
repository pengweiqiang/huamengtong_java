package net.shopin.hmtpdamw.apiresult;

import net.shopin.jiaxing.rest.framework.api.BaseEntity;

/**
 * Created by kanglei on 24/10/2016.
 * @param <T>
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ApiResultResponse2<T> {

	private boolean success;
	private T body;
    
	private String code;
	private String desc;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
