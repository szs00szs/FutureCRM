package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.SalesOrderMapper;
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

	public List<SalesOrder> findOrdersList() {
		return salesOrderMapper.findOrdersList();
	}

	public long getOrdersCount() {
		return salesOrderMapper.getOrdersCount();
	}

	@Override
	public void addOrder(SalesOrder salesOrder) {
		System.out.println("当前order：" + salesOrder);
		salesOrderMapper.addOrder(salesOrder);

	}

	@Override
	public void deleteOrderById(int id) {
		salesOrderMapper.deleteOrderById(id);
	}

}
