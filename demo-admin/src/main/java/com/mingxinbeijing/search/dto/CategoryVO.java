package com.mingxinbeijing.search.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.mingxinbeijing.dao.model.Category;

public class CategoryVO extends Category implements Serializable {
	private static final long serialVersionUID = -3098803261394767797L;	
	public CategoryVO(Category category2, List<Category> list) {
		BeanUtils.copyProperties(category2, this);
		childs = list;
	}
	List<Category> childs = new ArrayList<Category>();
	public List<Category> getChilds() {
		return childs;
	}
	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}
	
	
}
