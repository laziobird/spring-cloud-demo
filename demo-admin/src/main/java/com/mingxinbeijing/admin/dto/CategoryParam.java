package com.mingxinbeijing.admin.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分类传递参数
 * @author jiangzhiwei
 * @date 2022/11/30
 */

public class CategoryParam {

    @NotNull(message = "分类名称不能为空")
    private String categoryName;

    @Min(value = 1, message = "排序最小为1")
    private Integer weightSort;
    
    @Min(value = 1,message = "分类级别")
    private Byte level;
    
    /**
     * 父分类id，一级分类默认父分类0
     *
     * @mbg.generated
     */
    private Long parentId;        
    
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public Integer getWeightSort() {
		return weightSort;
	}

	public void setWeightSort(Integer weightSort) {
		this.weightSort = weightSort;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

    
}
