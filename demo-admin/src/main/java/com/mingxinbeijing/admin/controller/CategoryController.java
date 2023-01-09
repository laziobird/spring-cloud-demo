package com.mingxinbeijing.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingxinbeijing.admin.dto.CategoryDetail;
import com.mingxinbeijing.admin.dto.CategoryParam;
import com.mingxinbeijing.admin.dto.CategorySortParam;
import com.mingxinbeijing.admin.dto.CategoryVO;
import com.mingxinbeijing.admin.dto.PageParam;
import com.mingxinbeijing.admin.service.CategoryService;
import com.mingxinbeijing.agent.tool.HttpTool;
import com.mingxinbeijing.common.api.CommonPage;
import com.mingxinbeijing.common.api.CommonResult;
import com.mingxinbeijing.dao.model.Category;

/**
 * 分类API
 * 
 * @author jiangzhiwei
 * @date 2022/11/30
 */

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<Integer> create(@Valid @RequestBody CategoryParam categoryParam) {
		int count = categoryService.insertCagegory(categoryParam);
		if (count > 0) {
			return CommonResult.success(count);
		} else {
			return CommonResult.failed();
		}
	}

	@RequestMapping(value = "/category/list", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<CommonPage<CategoryVO>> getList(@RequestBody PageParam page) {
		List<Category> productList = categoryService.listPage(page.getPageSize(), page.getPageNum());
		CategoryDetail cd = new CategoryDetail(productList);
		return CommonResult.success(CommonPage.restPage(cd.getCategoryList()));
	}

	@RequestMapping(value = "/category/sort", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<String> updateSort(@Valid @RequestBody CategorySortParam csp) {
		try {
			categoryService.updateCategorySort(csp.getCategoryAId(), csp.getSortWeightA(), csp.getCategoryBId(), csp.getSortWeightB());
		} catch (Exception e) {
			return CommonResult.failed(e.getMessage());
		}
		return CommonResult.success(" 更新分类成功 ");
	}

}
