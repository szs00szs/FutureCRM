package com.future.hist.crm.service;

import java.util.List;

/**
 * 商品类别
 */
import com.future.hist.crm.domain.CommodityCategory;

public interface CommodityCategoryService {

	public List<CommodityCategory> findCategoryList();

	public CommodityCategory findCategoryById(int id);

	public void addCategory(CommodityCategory commodityCategory);

	public void editCategory(CommodityCategory commodityCategory);

	public void deleteCategory(int id);

}
