package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.Commodity;

public interface CommodityService {

	public List<Commodity> findCommodityList();

	public Commodity findCommodityById(int id);

	public void addCommodity(Commodity commodity);

	public void editCommodity(Commodity commodity);

	public void deleteCommodity(int id);

}
