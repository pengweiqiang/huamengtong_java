package net.shopin.hmtpdamw.apiresult;

/**
 * Created by pengweiqiang on 24/10/2016.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ApiResultResponse {

	private boolean success;
	private BodyResponse body;
//	private BodyResponse<T> body;
    
	private String code;
	private String desc;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public BodyResponse getBody() {
		return body;
	}
	public void setBody(BodyResponse body) {
		this.body = body;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc==null?"":desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
