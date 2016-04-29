package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.CommodityCategoryMapper;
import com.future.hist.crm.domain.CommodityCategory;
import com.future.hist.crm.service.CommodityCategoryService;

@Service
@Transactional
public class CommodityCategoryServiceImpl implements CommodityCategoryService {

	@Autowired
	private CommodityCategoryMapper commodityCategoryMapper;

	public List<CommodityCategory> findCategoryList() {
		return commodityCategoryMapper.findCategoryList();
	}

	public CommodityCategory findCategoryById(int id) {

		return commodityCategoryMapper.findCategoryById(id);
	}

	public void addCategory(CommodityCategory commodityCategory) {
		commodityCategoryMapper.addCategory(commodityCategory);
	}

	public void editCategory(CommodityCategory commodityCategory) {
		commodityCategoryMapper.editCategory(commodityCategory);
	}

	public void deleteCategory(int id) {
		commodityCategoryMapper.deleteCategory(id);
	}

}
