package net.shopin.hmtpdamw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="pdamw",locations="classpath:api.properties")
public class ApiUrlConfig {
	
	private String ssdUrl;
	private String promotionUrl;//促销
	private String omsUrl;
	private String payUrl;//支付地址
	private String memberUrl;
	private String loginUrl;
	private String cartUrl;//购物车地址
	private String serverVersion;//服务器版本号
	
	public String getSsdUrl() {
		return ssdUrl;
	}
	public void setSsdUrl(String ssdUrl) {
		this.ssdUrl = ssdUrl;
	}
	
	public String getPromotionUrl() {
		return promotionUrl;
	}
	public void setPromotionUrl(String promotionUrl) {
		this.promotionUrl = promotionUrl;
	}
	public String getOmsUrl() {
		return omsUrl;
	}
	public void setOmsUrl(String omsUrl) {
		this.omsUrl = omsUrl;
	}
	
	public String getPayUrl() {
		return payUrl;
	}
	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
	public String getMemberUrl() {
		return memberUrl;
	}
	public void setMemberUrl(String memberUrl) {
		this.memberUrl = memberUrl;
	}
	
	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getCartUrl() {
		return cartUrl;
	}
	public void setCartUrl(String cartUrl) {
		this.cartUrl = cartUrl;
	}
	public String getServerVersion() {
		return serverVersion;
	}
	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}
	
	
	
}
