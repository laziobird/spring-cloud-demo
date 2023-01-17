package com.mingxinbeijing.search.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;

public class CategorySortParam  implements Serializable {

	private static final long serialVersionUID = -4604160565054198831L;

	private long categoryAId ;
	@Min(1)	
	private int sortWeightA;
	private long categoryBId;
	@Min(1)	
	private int sortWeightB;
	public long getCategoryAId() {
		return categoryAId;
	}
	public void setCategoryAId(long categoryAId) {
		this.categoryAId = categoryAId;
	}
	public int getSortWeightA() {
		return sortWeightA;
	}
	public void setSortWeightA(int sortWeightA) {
		this.sortWeightA = sortWeightA;
	}
	public long getCategoryBId() {
		return categoryBId;
	}
	public void setCategoryBId(long categoryBId) {
		this.categoryBId = categoryBId;
	}
	public int getSortWeightB() {
		return sortWeightB;
	}
	public void setSortWeightB(int sortWeightB) {
		this.sortWeightB = sortWeightB;
	}
	
	
	
}
