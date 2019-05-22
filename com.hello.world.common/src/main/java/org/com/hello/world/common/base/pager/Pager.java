package org.com.hello.world.common.base.pager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 通用分页类
 * @author ht
 *
 */
public class Pager implements Serializable{
	
	private Integer pageNo;
	private Integer pageSize = 10;
	private Integer totalItems;
	private List<?> result;
	private HashMap<String, Object> searchInfo;
	private boolean isAllResult;
	
	public Integer getPageNo() {
		return (pageNo==null || pageNo>=Integer.MAX_VALUE)?1:pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalItems() {
		return this.result==null ? 0 : this.result.size();
	}
	
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
	public List<?> getResult() {
		return result;
	}
	
	public void setResult(List<?> result) {
		this.result = result;
	}
	
	public HashMap<String, Object> getSearchInfo() {
		return searchInfo;
	}
	
	public void setSearchInfo(HashMap<String, Object> searchInfo) {
		this.searchInfo = searchInfo;
	}
	
	public boolean isAllResult() {
		return isAllResult;
	}

	public void setAllResult(boolean isAllResult) {
		this.isAllResult = isAllResult;
		if(isAllResult){
			this.pageSize = this.result.size();
			this.pageNo = 1;
		}
	}
	
	public boolean isHasNext(Integer pageNo){
		if(getTotalItems()/getPageSize() > pageNo){
			return true;
		}
		return false;
	}
	
	public boolean isHasPrev(int pageNo){
		if(pageNo > 1){
			return true;
		}
		return false;
	}
	
	public Integer doNext(int pageNo){
		if(isHasNext(pageNo)){
			return pageNo+1;
		}
		return pageNo;
	}
	
	public Integer doPrev(){
		if(isHasPrev(pageNo)){
			return pageNo-1;
		}
		return 1;
	}

}
