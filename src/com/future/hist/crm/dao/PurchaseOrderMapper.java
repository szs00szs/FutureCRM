package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.PurchaseOrder;
import com.future.hist.crm.domain.SalesOrder;

/**
 * 进货单
 */
public interface PurchaseOrderMapper {

	/**
	 * 查询所有销售单
	 */
	public List<PurchaseOrder> findOrdersList();

	/**
	 * 获取所有的订单数量
	 */
	public long getOrdersCount();

	/**
	 * 添加新的销售单
	 */
	public void addOrder(PurchaseOrder purchaseOrder);

	/**
	 * 根据id查询订单
	 */
	public PurchaseOrder findOrderById(int id);

	/**
	 * 根据id删除订单
	 */
	public void deleteOrderById(int id);
 
}
