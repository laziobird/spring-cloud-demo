package com.mingxinbeijing.search.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mingxinbeijing.search.config.AdminConstant;
import com.mingxinbeijing.search.dto.CategoryParam;
import com.mingxinbeijing.search.service.CategoryService;
import com.mingxinbeijing.common.tool.IDUtils;
import com.mingxinbeijing.dao.mapper.CategoryMapper;
import com.mingxinbeijing.dao.model.Category;
import com.mingxinbeijing.dao.model.CategoryExample;
/**
 * 课程分类
 * @author jiangzhiwei
 * @date 2022/11/30
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    
    
    
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);   

    @Override
    public int insertCagegory(CategoryParam categoryDto) {
    	//第一步，差出排序序列号，如果当前层级没有分类数据，默认排序1
        CategoryExample categoryExample = new CategoryExample();
   
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andLevelEqualTo(categoryDto.getLevel());
        //删除的排除掉
        criteria.andIsDeletedEqualTo(AdminConstant.CATEGORY_DEL_NO);   
      
        //重新计算权重
        int count = (int) categoryMapper.countByExample(categoryExample);
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto,category);
        category.setWeightSort(++count);
        category.setCategoryId(IDUtils.createID());
        category.setCreateTime(new Date());
        if(category.getLevel().intValue()==1) {
        	//一级分类父分类没有
            category.setParentId((long) 0);
        }
        return categoryMapper.insertSelective(category);
    }
    
    @Override
    public List<Category> listPage(int pageNum, int pageSize) {
        //PageHelper.startPage(pageNum, pageSize);
        
        CategoryExample categoryExample = new CategoryExample();
        
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        //删除的排除掉
        criteria.andIsDeletedEqualTo(AdminConstant.CATEGORY_DEL_NO);
      
        return categoryMapper.selectByExample(categoryExample);
    }
    
    /**
     * 更新分类排序
     * @param categoryA
     * @param sortWeightA
     * @param categoryB
     * @param sortWeightB
     * @return
     * @throws Exception 
     */
    @Transactional
    @Override
    public int updateCategorySort(long categoryAId, int sortWeightA ,long categoryBId,int sortWeightB) throws Exception {
    	Category categoryA = new Category();
    	categoryA.setWeightSort(sortWeightB);
    	     
    	CategoryExample exampleA = new CategoryExample();
        
        CategoryExample.Criteria criteria = exampleA.createCriteria();  
        criteria.andCategoryIdEqualTo(categoryAId);
    	
		int ok = categoryMapper.updateByExampleSelective(categoryA,exampleA);  
		if(ok==1) {
	    	Category categoryB = new Category();
	    	categoryB.setWeightSort(sortWeightA);
	    	     
	    	CategoryExample exampleB = new CategoryExample();
	        
	        CategoryExample.Criteria criteriaB = exampleB.createCriteria();  
	        criteriaB.andCategoryIdEqualTo(categoryBId);		
	        ok = categoryMapper.updateByExampleSelective(categoryB,exampleB);  
	        if(ok==1) {
	        	return 1;
	        }	        	
		}
		throw new Exception(" 操作失败");
    }     
    
    
    
}
