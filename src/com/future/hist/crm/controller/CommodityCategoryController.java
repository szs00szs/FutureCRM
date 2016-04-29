package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.CommodityCategory;
import com.future.hist.crm.service.CommodityCategoryService;

/**
 * 商品类别
 */
@Controller
@RequestMapping("/category")
public class CommodityCategoryController {

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	/**
	 * 查询所有商品类别
	 */
	@RequestMapping("/queryCategories")
	public String queryCategories(Map<String, Object> map) {
		List<CommodityCategory> categoryList = commodityCategoryService.findCategoryList();
		map.put("categoryList", categoryList);
		return "category/categoriesList";
	}

	/**
	 * 添加商品类别页面
	 */
	@RequestMapping("/addCategoryUI")
	public String addCategoryUI() {
		return "category/addCategory";
	}

	/**
	 * 执行商品类别添加
	 */
	@RequestMapping("/addCategory")
	public String addCategory(CommodityCategory commodityCategory) {
		commodityCategoryService.addCategory(commodityCategory);
		return "forward:queryCategories.action";
	}

	/**
	 * 修改商品类别页面
	 */
	@RequestMapping("/editCategoryUI")
	public String editCategoryUI(int id, Map<String, Object> map) {
		CommodityCategory category = commodityCategoryService.findCategoryById(id);
		map.put("category", category);
		return "category/editCategory";
	}

	/**
	 * 执行商品类别修改
	 */
	@RequestMapping("/editCategory")
	public String editCategory(CommodityCategory commodityCategory) {
		commodityCategoryService.editCategory(commodityCategory);
		return "forward:queryCategories.action";
	}

	/**
	 * 商品类别删除
	 */
	@RequestMapping("/deleteCategory")
	public String deleteCategory(int id) {
		commodityCategoryService.deleteCategory(id);
		return "forward:queryCategories.action";
	}

}
