package com.future.hist.crm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.CommodityMapper;
import com.future.hist.crm.dao.PurchaseOrderMapper;
import com.future.hist.crm.domain.Commodity;
import com.future.hist.crm.domain.PurchaseOrder;
import com.future.hist.crm.service.PurchaseOrderService;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderMapper purchaseOrderMapper;
	
	@Autowired
	private CommodityMapper commodityMapper;
	
	

	public List<PurchaseOrder> findOrdersList() {

		return purchaseOrderMapper.findOrdersList();
	}

	public long getOrdersCount() {
		return 0;
	}

	public void addOrder(PurchaseOrder purchaseOrder) {
		// 更新数据库
		int id = purchaseOrder.getCommodity().getId().intValue();
		Commodity commodity = commodityMapper.findCommodityById(id);
		commodity.setPurchaseQuantity(purchaseOrder.getCommodityCount()+commodity.getPurchaseQuantity());
		commodity.setCommodityQuantity(purchaseOrder.getCommodityCount()+commodity.getCommodityQuantity());
		// 判断创建日期
		if (purchaseOrder.getCreateTime()==null) {
			purchaseOrder.setCreateTime(new Date());
		}
		purchaseOrderMapper.addOrder(purchaseOrder);
	}

	public void deleteOrderById(int id) {
		purchaseOrderMapper.deleteOrderById(id);
	}

	public PurchaseOrder findOrderById(int id) {
		
		return purchaseOrderMapper.findOrderById(id);
	}

}
