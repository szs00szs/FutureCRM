package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.SalesOrder;
import com.future.hist.crm.page.Page;


/**
 * 销售订单
 */
public interface SalesOrderMapper {

	/**
	 * 查询所有销售单
	 */
	public List<SalesOrder> findOrdersList(Long userId,Page page);

	/**
	 * 获取所有的订单数量
	 */
	public long getOrdersCount(Long userId);

	/**
	 * 添加新的销售单
	 */
	public void insert(SalesOrder salesOrder);

}
