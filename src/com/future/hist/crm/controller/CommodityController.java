package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Commodity;
import com.future.hist.crm.domain.CommodityCategory;
import com.future.hist.crm.domain.PageParameter;
import com.future.hist.crm.service.CommodityCategoryService;
import com.future.hist.crm.service.CommodityService;

/**
 * 商品
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private CommodityCategoryService commodityCategoryService;

	/**
	 * 查询所有商品
	 */
	@RequiresPermissions("commodity:queryCommodities")
	@RequestMapping("/queryCommodities/{currentPage}")
	public String queryCommodities(@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map) {
		
		BaseSearch baseSearch = new BaseSearch();
		int ordersCount = commodityService.getCount();
		PageParameter pageParameter = new PageParameter(PageParameter.DEFAULT_PAGE_SIZE, currentPage, ordersCount);
		baseSearch.setPage(pageParameter);
		
		List<Commodity> commodityList = commodityService.findCommodityListByPage(baseSearch);
		map.put("commodityList", commodityList);
		map.put("pageParameter", pageParameter);
		return "commodity/commoditiesList";
	}

	/**
	 * 添加商品页面
	 */
	@RequiresPermissions("commodity:addCommodity")
	@RequestMapping(value = "/addCommodity",method = RequestMethod.GET)
	public String addCommodityUI(Map<String, Object> map) {
		List<CommodityCategory> categoryList = commodityCategoryService.findCategoryList();

		map.put("categoryList", categoryList);
		String commodityNumber = UUID.randomUUID().toString().substring(0, 18);
		map.put("commodityNumber", commodityNumber);
		return "commodity/addCommodity";
	}

	/**
	 * 执行商品添加
	 */
	@RequiresPermissions("commodity:addCommodity")
	@RequestMapping(value = "/addCommodity" , method = RequestMethod.POST)
	public String addCommodity(Commodity commodity) {
		commodityService.addCommodity(commodity);
		return "forward:queryCommodities.action";
	}

	/**
	 * 修改商品页面
	 */
	@RequiresPermissions("commodity:editCommodity")
	@RequestMapping(value = "/editCommodity" , method = RequestMethod.GET)
	public String editCommodityUI(int id, Map<String, Object> map) {
		Commodity commodity = commodityService.findCommodityById(id);
		List<CommodityCategory> categoryList = commodityCategoryService.findCategoryList();
		map.put("commodity", commodity);
		map.put("categoryList", categoryList);

		return "commodity/editCommodity";
	}

	/**
	 * 执行商品修改
	 */
	@RequiresPermissions("commodity:editCommodity")
	@RequestMapping(value = "/editCommodity" , method = RequestMethod.POST)
	public String editCommodity(Commodity commodity) {
		commodityService.editCommodity(commodity);

		return "forward:queryCommodities.action";
	}

	/**
	 * 删除商品
	 */
	@RequiresPermissions("commodity:delete")
	@RequestMapping("/deleteCommodity")
	public String deleteCommodity(int id) {
		commodityService.deleteCommodity(id);
		return "forward:queryCommodities.action";
	}

}
