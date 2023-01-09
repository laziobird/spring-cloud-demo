package com.mingxinbeijing.admin.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PageParam {
	@Min(1)
	private Integer pageNum = 1;
	@Max(10000)
	@Min(1)	
	private Integer pageSize = 1000;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
