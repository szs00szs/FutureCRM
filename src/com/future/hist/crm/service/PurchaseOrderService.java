package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.PurchaseOrder;

public interface PurchaseOrderService {

	// 销售单查询列表(分页)
	public List<PurchaseOrder> findOrdersListByPage(BaseSearch baseSearch);

	// 销售单的数量
	public int getOrdersCount();

	// 添加新的销售单
	public void addOrder(PurchaseOrder purchaseOrder);

	// 删除订单
	public void deleteOrderById(int id);

	// 根据id查询订单
	public PurchaseOrder findOrderById(int id);

}
