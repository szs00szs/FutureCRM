package com.future.hist.crm.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.future.hist.crm.domain.SalesOrder;
import com.future.hist.crm.service.SalesOrderService;

@Controller
@RequestMapping("/sales")
public class SalesOrderController {

	// 注入 SalesOrderService
	@Autowired
	private SalesOrderService salesOrderService;

	// 添加订单页面
	@RequestMapping("/addOrderUI")
	public String addOrderUI() {
		return "salesOrder/addOrderUI";
	}

	// 添加订单
	@RequestMapping("/addOrder")
	public String addOrder(HttpServletRequest request) {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSaleNumber(request.getParameter("saleNumber"));
		salesOrder.setContactPhone(request.getParameter("contactPhone"));
		salesOrder.setDeliveryAddress(request.getParameter("deliveryAddress"));
		salesOrder.setRemark(request.getParameter("remark"));
		salesOrder.setGoods(request.getParameter("goods"));
		salesOrder.setCreateTime(new Date());
		salesOrderService.addOrder(salesOrder);
		System.out.println("执行添加");
		return "forward:queryOrders.action";
	}

	// 查询所有的销售订单
//	@RequestMapping("/queryOrders")
//	public ModelAndView queryOrders() {
//		List<SalesOrder> ordersList = salesOrderService.findOrdersList(salesOrder.getSalesman().getId());
//
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("ordersList", ordersList);
//
//		modelAndView.setViewName("ordersList");
//		return modelAndView;
//
//	}
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
		System.out.println("前台传入id："+id);
		salesOrderService.deleteOrderById(id);
		return "forward:queryOrders.action";
	}
	
	// 修改订单页面
	public String editOrder(SalesOrder salesOrder){
		
		
		return "editOrder";
		
		
		
	}

}
