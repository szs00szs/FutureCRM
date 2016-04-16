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

	public void addOrder(SalesOrder salesOrder) {
		salesOrderMapper.addOrder(salesOrder);
	}

	public void deleteOrderById(int id) {
		salesOrderMapper.deleteOrderById(id);
	}

	public SalesOrder findOrderById(int id) {
		return salesOrderMapper.findOrderById(id);
	}

}
