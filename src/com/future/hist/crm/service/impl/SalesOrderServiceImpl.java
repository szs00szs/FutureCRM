package com.future.hist.crm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.CommodityMapper;
import com.future.hist.crm.dao.SalesOrderMapper;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Commodity;
import com.future.hist.crm.domain.SalesOrder;
import com.future.hist.crm.service.SalesOrderService;

/**
 * 销售单
 */
@Service
@Transactional
public class SalesOrderServiceImpl implements SalesOrderService {

	// 注入mapper
	@Autowired
	private SalesOrderMapper salesOrderMapper;

	@Autowired
	private CommodityMapper commodityMapper;

	public List<SalesOrder> findOrdersListByPage(BaseSearch baseSearch) {
		return salesOrderMapper.findOrdersListByPage(baseSearch);
	}

	public int getOrdersCount() {
		return salesOrderMapper.getOrdersCount();
	}

	public void addOrder(SalesOrder salesOrder) {
		// 更新商品库存
		int id = salesOrder.getCommodity().getId().intValue();

		Commodity commodity = commodityMapper.findCommodityById(id);
		commodity.setCommodityQuantity(commodity.getCommodityQuantity() - salesOrder.getCommodityCount());
		commodityMapper.editCommodity(commodity);
		salesOrder.setCommodity(commodity);
		// 判断创建日期
		if (salesOrder.getCreateTime() == null) {
			salesOrder.setCreateTime(new Date());
		}
		salesOrderMapper.addOrder(salesOrder);
	}

	public void deleteOrderById(int id) {
		salesOrderMapper.deleteOrderById(id);
	}

	public SalesOrder findOrderById(int id) {
		return salesOrderMapper.findOrderById(id);
	}
	

}
