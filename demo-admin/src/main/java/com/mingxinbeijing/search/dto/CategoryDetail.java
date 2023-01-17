package com.mingxinbeijing.search.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mingxinbeijing.dao.model.Category;

/**
 * 封装分类的组合
 * 
 * @author jiangzhiwei
 * @date 2022/12/01
 */
public class CategoryDetail {
	private List<CategoryVO> categoryList = new ArrayList<CategoryVO>();

	public CategoryDetail(List<Category> list) {
		initData(list);
	}
	// 初始化分类嵌套逻辑
	private void initData(List<Category> list) {
		Map<Long, List<Category>> categoryMap = new HashMap<Long,  List<Category>>();
		
		List<Category> reList = new ArrayList<Category>();
		for (Category category : list) {
			// 拿一级分类,初始化map
			if (category.getLevel().intValue() == 1) {
				reList.add(category);
				List<Category> temp = new ArrayList<Category>();
				categoryMap.put(category.getCategoryId(), temp);
			}
		}
		// 按权重排序
		reList.sort((x, y) -> Integer.compare(x.getWeightSort(), y.getWeightSort()));
		
		for (Category categoryChild : list) {			
			for (Category c : reList) {
				// 拿一级分类
				if (categoryChild.getLevel().intValue() == 2 && categoryChild.getParentId().equals(c.getCategoryId() )) {				
					categoryMap.get(c.getCategoryId()).add(categoryChild);				
				}				
			}
		}
		
		//map 里面list做排序
		for (Long key : categoryMap.keySet()) {
			categoryMap.get(key).sort((x, y) -> Integer.compare(x.getWeightSort(), y.getWeightSort()));
		}		
		for (Category category2 : reList) {
			CategoryVO cVO = new CategoryVO(category2,categoryMap.get(category2.getCategoryId()));
			categoryList.add(cVO);
		}	
	}
	public List<CategoryVO> getCategoryList() {
		return categoryList;
	}


}
