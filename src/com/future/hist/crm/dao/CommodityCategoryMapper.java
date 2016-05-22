package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.CommodityCategory;

/**
 * 商品类别
 */
public interface CommodityCategoryMapper {
	public List<CommodityCategory> findCategoryList();

	public List<CommodityCategory> findCategoryListByPage(BaseSearch baseSearch);
	
	public CommodityCategory findCategoryById(int id);

	public void addCategory(CommodityCategory commodityCategory);

	public void editCategory(CommodityCategory commodityCategory);

	public void deleteCategory(int id);
	
	public int getCount();


}
