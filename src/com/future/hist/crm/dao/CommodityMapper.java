package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.Commodity;

/**
 * 商品
 */
public interface CommodityMapper {

	public List<Commodity> findCommodityList();

	public Commodity findCommodityById(int id);

	public void editCommodity(Commodity commodity);

	public void deleteCommodity(int id);

	public void addCommodity(Commodity commodity);

}
