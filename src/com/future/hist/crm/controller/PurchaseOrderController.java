package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.dao.SupplierMapper;
import com.future.hist.crm.domain.Commodity;
import com.future.hist.crm.domain.PurchaseOrder;
import com.future.hist.crm.domain.Supplier;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.CommodityService;
import com.future.hist.crm.service.PurchaseOrderService;
import com.future.hist.crm.service.UserService;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private SupplierMapper supplierMapper;

	// 查询所有的进货单
	@RequiresPermissions("purchase:queryOrders")
	@RequestMapping("/queryOrders")
	public String queryOrders(Map<String, Object> map) {
		List<PurchaseOrder> ordersList = purchaseOrderService.findOrdersList();
		map.put("ordersList", ordersList);
		return "purchaseOrder/ordersList";
	}

	// 添加进货单页面
	@RequiresPermissions("purchase:addOrder")
	@RequestMapping(value = "/addOrder" , method = RequestMethod.GET)
	public String addOrderUI(Map<String, Object> map) {
		List<User> userList = userService.getAllUser();
		List<Supplier> supplierList = supplierMapper.findSupplierList();
		List<Commodity> commodityList = commodityService.findCommodityList();

		String purchaseNo = UUID.randomUUID().toString().substring(0, 18);
		map.put("purchaseNo", purchaseNo);
		map.put("userList", userList);
		map.put("commodityList", commodityList);
		map.put("supplierList", supplierList);
		return "purchaseOrder/addOrderUI";
	}

	// 添加进货单
	@RequiresPermissions("purchase:addOrder")
	@RequestMapping(value = "/addOrder" , method = RequestMethod.POST)
	public String addOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderService.addOrder(purchaseOrder);
		return "forward:queryOrders.action";
	}

	// 删除进货单
	@RequiresPermissions("purchase:deleteOrder")
	@RequestMapping("/deleteOrderById")
	public String deleteOrderById(int id) {
		purchaseOrderService.deleteOrderById(id);
		return "forward:queryOrders.action";
	}

	// 查询详细信息
	@RequiresPermissions("purchase:orderDetails")
	@RequestMapping("/orderDetails")
	public String orderDetails(int id, Map<String, Object> map) {
		PurchaseOrder purchaseOrder = purchaseOrderService.findOrderById(id);
		map.put("purchaseOrder", purchaseOrder);
		return "purchaseOrder/orderDetails";
	}

}
