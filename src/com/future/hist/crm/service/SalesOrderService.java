package com.future.hist.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.future.hist.crm.domain.SalesOrder;
import com.future.hist.crm.page.Page;

/**
 * 销售单service接口
 */
@Service
public interface SalesOrderService {
	
	// 销售单查询列表(分页)
	public List<SalesOrder> findOrdersList(Long userId,Page page);
	
	//销售单的数量
	public long getOrdersCount(Long userId);
	
	//添加新的销售单
	public void insert(SalesOrder salesOrder);
	
}
