package net.shopin.hmtpdamw.apiresult;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.shopin.hmtpdamw.constants.InfoConstants.CodeInfo;
import net.shopin.jiaxing.rest.framework.api.BaseEntity;
import net.shopin.jiaxing.rest.framework.api.EC;

/**
 * API pad result 对pad输入格式
 * @author pengweiqiang
 * @Date:2016年11月11日
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ApiPadResult {


    private static final String PAGE = "page";
    private static final String ENTITY = "entity";

//    private boolean success;
    private String code;
    private String codeInfo;
//    private Map body = new TreeMap();
    private Object data;

    /**
     * codeInfo.
     *
     * @return the codeInfo
     * @since JDK 1.7
     */
    public String getCodeInfo() {
        return codeInfo;
    }

    /**
     * desc.
     *
     * @param codeInfo
     *            the codeInfo to set
     * @since JDK 1.7
     */
    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    /**
     *
     * Creates a new instance of ApiPadResult. 失败结果
     *
     * @param code
     * @param desc
     */
    private ApiPadResult(CodeInfo codeInfo) {
//        this.success = Boolean.FALSE;
        this.code = codeInfo.getCode();
        this.codeInfo = codeInfo.getCodeInfo();
    }
    
    private ApiPadResult(String code ,String codeInfo){
    	this.code = code;
    	this.codeInfo = codeInfo;
    }

    private ApiPadResult(CodeInfo codeInfo, BaseEntity entity) {
        this.code = codeInfo.getCode();
        this.codeInfo = codeInfo.getCodeInfo();
//        this.body.put(ENTITY, entity);
        this.data =JSONObject.toJSON(entity);
//        this.data = entity;
//        this.data = JSON.toJSONString(entity, SerializerFeature.WriteNonStringKeyAsString);
        // (page == null) ? (this.body.put(PAGE, new PagePadEntity())):();
    }

    private ApiPadResult(CodeInfo codeInfo, PagePadEntity entity) {
        this.code = codeInfo.getCode();
        this.codeInfo = codeInfo.getCodeInfo();
//        this.body.put(PAGE, entity);
        this.data = JSONObject.toJSON(entity);
        // (page == null) ? (this.body.put(PAGE, new PagePadEntity())):();
    }
    
    private ApiPadResult(CodeInfo codeInfo,Object data){
    	this.code = codeInfo.getCode();
    	this.codeInfo = codeInfo.getCodeInfo();
    	this.data = data;
    }

    // private ApiPadResult(Object o) {
    // this.body = new TreeMap();
    // this.success = Boolean.TRUE;
    // this.body.put(OBJ, o);
    // }



//	private ApiPadResult(boolean success) {
//		this.success = success;
//	}


//    private static ApiPadResult Y() {
//        return new ApiPadResult(Boolean.TRUE, new BaseEntity());
//    }

    public static ApiPadResult Y(PagePadEntity page) {
    	long totalPage = page.getTotal()/page.getPageSize() + (page.getTotal()%page.getPageSize()==0?0:1);
    	page.setTotalPage(totalPage);
        return new ApiPadResult(CodeInfo.操作成功, page);
    }
    public static ApiPadResult Y(CodeInfo codeInfo,PagePadEntity page) {
    	long totalPage = page.getTotal()/page.getPageSize() + (page.getTotal()%page.getPageSize()==0?0:1);
    	page.setTotalPage(totalPage);
        return new ApiPadResult(codeInfo, page);
    }

    public static ApiPadResult Y(BaseEntity entity) {
        return new ApiPadResult(CodeInfo.操作成功, entity);
    }
    
    public static ApiPadResult Y(CodeInfo codeInfo,BaseEntity entity) {
        return new ApiPadResult(codeInfo, entity);
    }
    
    public static ApiPadResult Y(Object data) {
        return new ApiPadResult(CodeInfo.操作成功, data);
    }
    
    public static ApiPadResult Y(CodeInfo codeInfo,Object data) {
        return new ApiPadResult(codeInfo, data);
    }

    public static ApiPadResult N() {
        return new ApiPadResult(CodeInfo.操作失败);
    }

    public static ApiPadResult N(String code, String desc) {
        return new ApiPadResult(code, desc);
    }
    
    
    public static ApiPadResult N(CodeInfo codeInfo,String memo){
    	return new ApiPadResult(codeInfo.getCode(),codeInfo.getCodeInfo()+memo);
    }
    public static ApiPadResult N(CodeInfo codeInfo){
    	return N(codeInfo,"");
    }
    
    public static ApiPadResult N(String memo){
    	return N(CodeInfo.操作失败,memo);
    }

    public static ApiPadResult N(EC ec) {
        return new ApiPadResult(ec.getCode(), ec.getDesc());
    }

    /**
     *
     * N:(这里用一句话描述这个方法的作用). <br/>
     *
     * @author kanglei
     * @param ec
     *            异常分类：大类 C01 通信异常 R02 请求参数异常 B03 业务异常
     * @param desc：异常描述，自定义
     * @return
     * @since JDK 1.7
     */
    public static ApiPadResult N(EC ec, String... descs) {
        StringBuffer sb = new StringBuffer();
        for (String desc : descs) {
            sb.append(desc).append("|");
        }
        return new ApiPadResult(ec.getCode(), sb.toString());
    }

//    /**
//     * success.
//     *
//     * @return the success
//     * @since JDK 1.7
//     */
//    public boolean isSuccess() {
//        return success;
//    }
//
//    /**
//     * success.
//     *
//     * @param success
//     *            the success to set
//     * @since JDK 1.7
//     */
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }

    /**
     *
     * setPage:用于返回分页结果. <br/>
     *
     * @author kanglei
     * @param page
     * @return
     * @since JDK 1.7
     */
    public ApiPadResult setPage(PagePadEntity page) {
//        this.success = Boolean.TRUE;
        this.code = CodeInfo.操作成功.getCode();
        this.codeInfo = CodeInfo.操作成功.getCodeInfo();		
//        this.body.put(PAGE, page);
        this.data = page;
        return this;
    }

    /**
     *
     * setObj:用于返回单个对象. <br/>
     *
     * @author kanglei
     * @param o
     * @return
     * @since JDK 1.7
     */
    public ApiPadResult setObj(BaseEntity o) {
//        this.body = new TreeMap();
//        this.success = Boolean.TRUE;
        this.code = CodeInfo.操作成功.getCode();
        this.codeInfo = CodeInfo.操作成功.getCodeInfo();
//        this.body.put(ENTITY, o);
        this.data = o;
        return this;
    }

    /**
     * code.
     *
     * @return the code
     * @since JDK 1.7
     */
    public String getCode() {
        return code;
    }

    /**
     * code.
     *
     * @param code
     *            the code to set
     * @since JDK 1.7
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * body.
     *
     * @return the body
     * @since JDK 1.7
     */

//    public Object getBody() {
//        return body;
//    }
    
    /**
     * data.
     *
     * @return the data
     * @since JDK 1.7
     */

    public Object getData() {
        return data;
    }

    // /**
    // * body.
    // *
    // * @param body the body to set
    // * @since JDK 1.7
    // */
    // public void setBody(Object body) {
    // this.body = body;
    // }

    /**
     *
     * TODO 重写toString方法.
     *
     *
     * QuoteFieldNames———-输出key时是否使用双引号,默认为true
     WriteMapNullValue——–是否输出值为null的字段,默认为false
     WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
     WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
     WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
     WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return JSON.toJSONString(this);
    }


}
