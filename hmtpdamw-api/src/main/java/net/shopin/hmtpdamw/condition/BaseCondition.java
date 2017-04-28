package net.shopin.hmtpdamw.condition;

/**
 * 请求条件基本参数
 * @author pengweiqiang
 * @Date:2017年04月28日
 */
public class BaseCondition extends Page{
	private Integer optUserSid;//操作人id
	private String supplySid;// 供应商SID
	private String userName;
	private String password;
	private String ipAddress; //IP地址
	private String macAddress; //mac地址
	private Integer shopSid;		//门店SID
	private String shopName;//门店名称
	private String appVersionName;//pad版本号
	
	
	public Integer getOptUserSid() {
		return optUserSid;
	}
	public void setOptUserSid(Integer optUserSid) {
		this.optUserSid = optUserSid;
	}
	public String getSupplySid() {
		return supplySid;
	}
	public void setSupplySid(String supplySid) {
		this.supplySid = supplySid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public Integer getShopSid() {
		return shopSid;
	}
	public void setShopSid(Integer shopSid) {
		this.shopSid = shopSid;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAppVersionName() {
		return appVersionName;
	}
	public void setAppVersionName(String appVersionName) {
		this.appVersionName = appVersionName;
	}
	
}
