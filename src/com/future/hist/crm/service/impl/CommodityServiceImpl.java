package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.CommodityMapper;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Commodity;
import com.future.hist.crm.service.CommodityService;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityMapper commodityMapper;

	public List<Commodity> findCommodityList() {

		return commodityMapper.findCommodityList();
	}

	public Commodity findCommodityById(int id) {

		return commodityMapper.findCommodityById(id);
	}

	public void editCommodity(Commodity commodity) {
		commodityMapper.editCommodity(commodity);

	}

	public void deleteCommodity(int id) {
		commodityMapper.deleteCommodity(id);

	}

	public void addCommodity(Commodity commodity) {
		commodityMapper.addCommodity(commodity);
	}

	@Override
	public List<Commodity> findCommodityListByPage(BaseSearch baseSearch) {
		return commodityMapper.findCommodityListByPage(baseSearch);
	}

	@Override
	public int getCount() {
		return commodityMapper.getCount();
	}

}
