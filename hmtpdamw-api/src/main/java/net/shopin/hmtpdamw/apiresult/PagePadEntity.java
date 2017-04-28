package net.shopin.hmtpdamw.apiresult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.shopin.jiaxing.rest.framework.api.BaseEntity;
import net.shopin.jiaxing.rest.framework.api.PageEntity;

public class PagePadEntity<T extends BaseEntity> {
	private long total =0;//总的结果集数量
	private long pageSize;//每页显示条数
	private long totalPage;//总页数
	private long currentPage=1;//当前页
	private List<T> list = new ArrayList<T>();
	private Map<String,Object> params = new HashMap<String,Object>();
	
	/**
	 * 
	 * addParam:添加查询参数. <br/>
	 * @author kanglei
	 * @param key
	 * @param value
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Object> addParam(String key,Object value){
		this.params.put(key, value);
		return this.params;
	}
	
	/**
	 * 
	 * getParamMap:获取查询参数Map. <br/>
	 *
	 * @author kanglei
	 * @return
	 * @since JDK 1.7
	 */
	public Map<String,Object> getParams(){
		return this.params;
	}
	
	
//	public PagePadEntity(){
//		this.params.put("start", this.start);
//		this.params.put("limit", this.limit);
//	}
	/**
	 * 
	 * Creates a new instance of PageEntity.
	 * 
	 * @param start
	 * @param limit 最大值1000，大于1000 为1000
	 */
//	public PagePadEntity(long start,long limit){
//		this.start = start;
//		this.limit = (limit > 1000)?1000:limit;
////		this.params.put("start", this.start);
////		this.params.put("limit", this.limit);
//	}
	
	
	
	
	/**
	 * list.
	 *
	 * @return  the list
	 * @since   JDK 1.7
	 */
	public List<T> getList() {
		return list;
	}
	/**
	 * list.
	 *
	 * @param   list    the list to set
	 * @since   JDK 1.7
	 */
	public void setList(List<T> list) {
		this.list = (list == null)? this.list:list;
	}
	/**
	 * start.
	 *
	 * @return  the start
	 * @since   JDK 1.7
	 */
//	public long getStart() {
//		return start;
//	}
	/**
	 * start.
	 *
	 * @param   start    the start to set
	 * @since   JDK 1.7
	 */
//	public void setStart(long start) {
//		this.start = start;
////		this.params.put("start", start);
//	}
	/**
	 * limit.
	 *
	 * @return  the limit
	 * @since   JDK 1.7
	 */
//	public long getLimit() {
//		return limit;
//	}
	/**
	 * limit.
	 *
	 * @param   limit    the limit to set
	 * @since   JDK 1.7
	 */
//	public void setLimit(long limit) {
//		this.limit = limit;
////		this.params.put("limit", limit);
//	}
	/**
	 * total.
	 *
	 * @return  the total
	 * @since   JDK 1.7
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * total.
	 *
	 * @param   total    the total to set
	 * @since   JDK 1.7
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	public long getPageSize() {
		return pageSize==0?10:pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	
	
	
	
}
