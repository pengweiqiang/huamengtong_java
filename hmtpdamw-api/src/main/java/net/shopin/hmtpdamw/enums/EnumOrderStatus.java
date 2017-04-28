package net.shopin.hmtpdamw.enums;
/**
 * 订单状态
 * @author pengweiqiang
 * @Date:2016年11月25日
 */
public enum EnumOrderStatus {
    作废("-1","作废"),
    超时0("0","超时"),
    等待支付1("1","等待支付"),
    已支付2("2","已支付"),
    调拨中3("3","调拨中"),
    确认收货4("4","确认收货"),
    ;

    private String refundStatus;
    private String refundStatusDesc;

    private EnumOrderStatus(String refundStatus,String refundStatusDesc){
        this.refundStatus = refundStatus;
        this.refundStatusDesc = refundStatusDesc;
    }

	public String getRefundStatus() {
		return refundStatus;
	}

	public String getRefundStatusDesc() {
		return refundStatusDesc;
	}

}
