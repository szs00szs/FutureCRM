package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.SalesOrder;


/**
 * 销售订单
 */
public interface SalesOrderMapper {

	/**
	 * 查询所有销售单
	 */
	public List<SalesOrder> findOrdersList(Long userId);

	/**
	 * 获取所有的订单数量
	 * 
	 */
	public long getOrdersCount();

	/**
	 * 添加新的销售单
	 */
	public int insert(SalesOrder salesOrder);

}
