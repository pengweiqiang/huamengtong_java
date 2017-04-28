package net.shopin.hmtpdamw.constants;
/**
 * 提示常量类
 * @author pengweiqiang
 *
 */
public class InfoConstants {
	public static String INFO_CODE_SUCCESS = "SUCCESS";
	public static String INFO_CODE_FAIL = "FAIL";
	public static String INFO_CODE_EXCEPTION = "EXCEPTION";


	public enum CodeInfo {

        参数不合法(INFO_CODE_FAIL,"参数不合法!"),
        地址不合法(INFO_CODE_EXCEPTION,"地址不合法，请检查参数是否正确"),
        日期格式不正确(INFO_CODE_FAIL,"日期格式不正确,正确格式应为:yyyy-MM-dd"),
        参数不能为空(INFO_CODE_FAIL,"参数不能为空!"),
		操作成功(INFO_CODE_SUCCESS,"操作成功!"),
		查询成功(INFO_CODE_SUCCESS,"查询成功!"),
		登陆成功(INFO_CODE_SUCCESS,"用户登陆成功!"),
		
		//--基本信息
		操作失败(INFO_CODE_FAIL,"操作失败!"),
		查询失败(INFO_CODE_FAIL,"查询失败! "),
		查询失败2(INFO_CODE_FAIL," "),
		接口调用超时(INFO_CODE_FAIL,"接口调用超时！"),
		供应商合同过期(INFO_CODE_FAIL,"该供应商没有品牌，找合同确认是否过期！"),
		用户名不能为空(INFO_CODE_FAIL,"用户名不能为空! "),
		用户名SID不能为空(INFO_CODE_FAIL,"OptUserSid不能为空! "),
		密码不能为空(INFO_CODE_FAIL,"密码不能为空! "),
		MAC地址不能为空(INFO_CODE_FAIL,"MAC地址不能为空！"),
		IP地址不能为空(INFO_CODE_FAIL,"IP地址不能为空! "),
		APP版本号不能为空(INFO_CODE_FAIL,"APP版本号不能为空"),
		门店ID不能为空(INFO_CODE_FAIL,"门店ID不能为空"),
		验证没通过(INFO_CODE_FAIL,"验证没通过! "),
		查询结果为空(INFO_CODE_FAIL,"查询结果为空！"),
		查询商品已存在(INFO_CODE_FAIL,"查询商品已存在！"),
		查询无此商品(INFO_CODE_FAIL,"查询无此商品！"),
		获取积分数据为空值(INFO_CODE_FAIL,"获取积分数据为空值！"),
				
		
		//--用户登录相关信息提示	
		登陆失败(INFO_CODE_FAIL,"登录失败! "),
		密码修改失败(INFO_CODE_FAIL,"密码修改失败! "),
		验权失败(INFO_CODE_FAIL,"没有访问权限! "),
		
		
		//异常情况		
		方法不存在(INFO_CODE_EXCEPTION,"方法不存在! "),
		方法为空(INFO_CODE_EXCEPTION,"方法为空! "),
		未知错误(INFO_CODE_EXCEPTION,"未知错误! "),		
		库存更新失败(INFO_CODE_EXCEPTION,"库存更新失败! "),
		库存不足(INFO_CODE_EXCEPTION,"库存不足! "),
		没有找到库存(INFO_CODE_EXCEPTION,"没有找到库存 不能撤销! "),
		
		自定义异常(INFO_CODE_EXCEPTION,"自定义异常！"),
		全局异常(INFO_CODE_EXCEPTION,"错误信息："),
		
        ;

    	private String code;
    	private String codeInfo;

		private CodeInfo() {
		}

		private CodeInfo(String code, String codeInfo) {
			this.code = code;
			this.codeInfo = codeInfo;
		}

		public String getCodeInfo() {
			return codeInfo;
		}

		public void setCodeInfo(String codeInfo) {
			this.codeInfo = codeInfo;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}



	}

	// -1 作废 0 草稿 1 等待导购确认是否有货 2 导购确认有货 3 已打印，未付款4 已付款，未提货 5 已经付款,已经提货 6 导购确认无货
	public enum SaleStauts {
		作废(-1, "作废"), 
		草稿(0, "草稿"), 
		等待导购确认是否有货(1, "等待导购确认是否有货"), 
		导购确认有货(2,"导购确认有货"), 
		已打印未付款(3, "已打印,未付款"), 
		已付款未提货(4, "已付款,未提货"), 
		已经付款已经提货(5, "已经付款,已经提货"), 
		导购确认无货(6, "导购确认无货");

		private int statusCode;
		private String statusDesc;

		private SaleStauts() {
		}

		private SaleStauts(int statusCode, String statusDesc) {
			this.statusCode = statusCode;
			this.statusDesc = statusDesc;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatusDesc() {
			return statusDesc;
		}

		public void setStatusDesc(String statusDesc) {
			this.statusDesc = statusDesc;
		}
	}
	//二维码 支付状态[-1 作废，0 初始化 ，1 等待支付 ，2.支付成功  ]
	public enum QrcodeSaleStauts {
		作废(-1, "作废"), 
		初始化(0, "初始化"), 
		等待支付(1, "等待支付"), 
		支付成功(2,"支付成功");
		private int statusCode;
		private String statusDesc;
		private QrcodeSaleStauts() {
		}
		private QrcodeSaleStauts(int statusCode, String statusDesc) {
			this.statusCode = statusCode;
			this.statusDesc = statusDesc;
		}
		public int getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}
		public String getStatusDesc() {
			return statusDesc;
		}
		public void setStatusDesc(String statusDesc) {
			this.statusDesc = statusDesc;
		}
	}
	
//	-1作废 0 草稿 1 打印退货单 3 退货入收银 4 导购确认收货
	public enum RefundStauts {
		作废(-1, "作废"), 
		草稿(0, "草稿"), 
		打印退货单(1, "打印退货单"), 
		退货入收银(3,"退货入收银"), 
		导购确认收货(4, "导购确认收货");
		private int statusCode;
		private String statusDesc;

		private RefundStauts() {
		}

		private RefundStauts(int statusCode, String statusDesc) {
			this.statusCode = statusCode;
			this.statusDesc = statusDesc;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatusDesc() {
			return statusDesc;
		}

		public void setStatusDesc(String statusDesc) {
			this.statusDesc = statusDesc;
		}
	}
	
	public enum RefundCheckStauts {
		审核拒绝(-1, "审核拒绝"), 
		未审核(0, "未审核"), 
		审核通过(1, "审核通过"); 
		private int statusCode;
		private String statusDesc;
		private RefundCheckStauts() {
		}
		private RefundCheckStauts(int statusCode, String statusDesc) {
			this.statusCode = statusCode;
			this.statusDesc = statusDesc;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
		}

		public String getStatusDesc() {
			return statusDesc;
		}

		public void setStatusDesc(String statusDesc) {
			this.statusDesc = statusDesc;
		}
	}

}
