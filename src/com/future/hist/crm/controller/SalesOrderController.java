package com.future.hist.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.future.hist.crm.domain.SalesOrder;
import com.future.hist.crm.page.Page;
import com.future.hist.crm.service.SalesOrderService;

@Controller
@RequestMapping("/sales")
public class SalesOrderController {

	// 注入 SalesOrderService
	@Autowired
	private SalesOrderService salesOrderService;

	private SalesOrder salesOrder;

	private Page page;

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	// 添加订单页面
	@RequestMapping("/addOrderUI")
	public String addOrderUI() {
		return "salesOrder/addOrderUI";
	}

	// 查询所有的销售订单
	@RequestMapping("/queryOrders")
	public ModelAndView queryOrders() {

		List<SalesOrder> ordersList = salesOrderService.findOrdersList(1L, page);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("ordersList", ordersList);

		modelAndView.setViewName("salesOrder/ordersList");
		return modelAndView;

	}

}
