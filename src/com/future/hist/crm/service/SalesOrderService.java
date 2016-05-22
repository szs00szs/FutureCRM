package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.SalesOrder;

/**
 * 销售单service接口
 */
public interface SalesOrderService {
	
	// 销售单查询列表(分页)
	public List<SalesOrder> findOrdersListByPage(BaseSearch baseSearch);
	
	//销售单的数量
	public int getOrdersCount();
	
	//添加新的销售单
	public void addOrder(SalesOrder salesOrder);
	
	// 删除订单
	public void deleteOrderById(int id);
	
	// 根据id查询订单
	public SalesOrder findOrderById(int id);
	
}
