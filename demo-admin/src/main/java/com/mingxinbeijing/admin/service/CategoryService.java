package com.mingxinbeijing.admin.service;

import java.util.List;

import com.mingxinbeijing.admin.dto.CategoryParam;
import com.mingxinbeijing.dao.model.Category;

/**
 * 
 * @author jiangzhiwei
 * @date 2022/11/29
 */
public interface CategoryService {

	int insertCagegory(CategoryParam categoryDto);
	
	List<Category> listPage(int pageNum, int pageSize);

	/**
	 * 更新分类排序
	 * @param categoryA
	 * @param sortWeightA
	 * @param categoryB
	 * @param sortWeightB
	 * @return
	 */
	int updateCategorySort(long categoryAId, int sortWeightA, long categoryBId, int sortWeightB) throws Exception;	
	

	
}
