package net.shopin.hmtpdamw.condition;
/**
 * 分页对象
 * @author pengweiqiang
 * @Date:2016年11月16日
 */
public class Page {
	protected int pageSize 		= 10  ; 		//每页显示数
	protected int currentPage 	= 1  ; 		//当前页面数
	protected int totalRecords  = 0  ;		//总记录数
	protected int totalPages  	= 0  ;		//总页数
	protected int startRecords 		= 0  ; 		//开始条数
	protected int endRecords  		= 0  ; 		//截至条数
	
	
	public Page() {
	}
	
	
	public Page(int pageSize,int currentPage,int totalRecords,int totalPages) {
		if(currentPage<= 1) currentPage = 1;
		this.pageSize = pageSize;
		this.currentPage = currentPage; 
		this.totalPages = totalPages;
		this.totalRecords = totalRecords;
		build();
	} 
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage<=1) currentPage = 1 ;
		this.currentPage = currentPage;
	}
	
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public void setTotalRecordsBuild(int totalRecords) {
		this.totalRecords = totalRecords;
		build();
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	
	public int getStartRecords() {
		return startRecords;
	}

	public void setStartRecords(int startRecords) {
		this.startRecords = startRecords;
	}

	public int getEndRecords() {
		return endRecords;
	}

	public void setEndRecords(int endRecords) {
		this.endRecords = endRecords;
	}

	public void build(){
		this.totalPages = (this.totalRecords+this.pageSize-1)/pageSize;
		if(this.currentPage>=this.totalPages)	this.currentPage = this.totalPages;
		this.startRecords = (this.currentPage - 1) * pageSize+1;
		 if (this.startRecords + this.pageSize > this.totalRecords)
             this.endRecords = this.totalRecords;
         else
        	 this.endRecords = this.startRecords + this.pageSize-1;
	}

}
