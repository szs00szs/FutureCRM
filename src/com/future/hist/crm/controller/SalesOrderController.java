package com.future.hist.crm.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.future.hist.crm.domain.Commodity;
import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.SalesOrder;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.CommodityService;
import com.future.hist.crm.service.ContactService;
import com.future.hist.crm.service.CustomerService;
import com.future.hist.crm.service.SalesOrderService;
import com.future.hist.crm.service.UserService;

@Controller
@RequestMapping("/sales")
public class SalesOrderController {

	// 注入 SalesOrderService
	@Autowired
	private SalesOrderService salesOrderService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ContactService contactService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommodityService commodityService;

	// 添加订单页面
	@RequestMapping("/addOrderUI")
	public String addOrderUI(Map<String, Object> map) {
		List<Customer> customerList = customerService.getAllCustomer();
		List<Contacts> contactsList = contactService.getAllContacts();
		List<User> salesmanList = userService.getAllUser();
		List<Commodity> commodityList = commodityService.findCommodityList();

		map.put("customerList", customerList);
		map.put("contactsList", contactsList);
		map.put("salesmanList", salesmanList);
		map.put("commodityList", commodityList);

		String saleNumber = UUID.randomUUID().toString().substring(0, 18);
		map.put("saleNumber", saleNumber);
		return "salesOrder/addOrderUI";
	}

	// 添加订单
	@RequestMapping("/addOrder")
	public String addOrder(SalesOrder salesOrder) throws ParseException {
	
		salesOrderService.addOrder(salesOrder);

		return "forward:queryOrders.action";
	}

	// 查询所有的销售订单
	@RequestMapping("/queryOrders")
	public ModelAndView queryOrders() {

		// 调用service查询订单列表
		List<SalesOrder> ordersList = salesOrderService.findOrdersList();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("ordersList", ordersList);
		modelAndView.setViewName("salesOrder/ordersList");
		return modelAndView;

	}

	// 根据id删除订单
	@RequestMapping("deleteOrderById")
	public String deleteOrderById(int id) {
		System.out.println("前台传入id：" + id);
		salesOrderService.deleteOrderById(id);
		return "forward:queryOrders.action";
	}

	// // 修改订单页面
	// @RequestMapping("editOrderById")
	// public String editOrderById(int id, Map<String, Object> map) {
	// System.out.println("修改:" + id);
	// SalesOrder salesOrder = salesOrderService.findOrderById(id);
	// System.out.println("待修改的：" + salesOrder);
	// map.put("salesOrder", salesOrder);
	// return "salesOrder/editOrder";
	// }

	// // 修改订单
	// @RequestMapping("editOrder")
	// public String editOrder(SalesOrder salesOrder) {
	// System.out.println("修改后：" + salesOrder);
	// System.out.println("修改的id=" + salesOrder.getId());
	// System.out.println("执行修改");
	// return "forward:queryOrders.action";
	// }

	// 订单详情
	@RequestMapping("orderDetails")
	public String orderDetails(int id, Map<String, Object> map) {
		SalesOrder salesOrder = salesOrderService.findOrderById(id);
		map.put("salesOrder", salesOrder);

		return "salesOrder/orderDetails";
	}

}
