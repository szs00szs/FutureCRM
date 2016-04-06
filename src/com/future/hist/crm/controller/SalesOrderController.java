package com.future.hist.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.future.hist.crm.domain.SalesOrder;
import com.future.hist.crm.service.SalesOrderService;

@Controller
@RequestMapping("/salesOrder")
public class SalesOrderController {

	// 注入 SalesOrderService
	@Autowired
	private SalesOrderService salesOrderService;

	@Resource
	private SalesOrder salesOrder;

	// 添加订单页面
	@RequestMapping("/addOrderUI")
	public String addOrderUI() {
		return "addOrderUI";
	}

	// 查询所有的销售订单
	@RequestMapping("/queryOrders")
	public ModelAndView queryOrders() {
		List<SalesOrder> ordersList = salesOrderService.findOrdersList(salesOrder.getSalesman().getId());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("ordersList", ordersList);

		modelAndView.setViewName("ordersList");
		return modelAndView;

	}

}
