package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.News;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.CustomerService;

/**
 * @author 羊羊
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer_list")
	public String CustomerList(Map<String , Object> map){
		List<Customer> customerList =customerService.getAllCustomer();
		map.put("customerList", customerList);
		return "customer/customer_list";
	}
	
	@RequestMapping("/customer_detail/{id}")
	public String customerDetail(Map<String , Object> map ,@PathVariable("id") Long id){
		Customer customer = customerService.getCustomerById(id);
		System.out.println("the customer is " + customer);
		map.put("customer", customer);
		return "customer/customer_detail";
	}
	
	@RequestMapping(value = "/customer_saveUI")
	public String saveUI(){
		return "customer/saveUI";
	}
	
	@RequestMapping(value = "/customer_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		Customer customer = customerService.getCustomerById(id);
		System.out.println(customer.getId());
		map.put("customer" , customer);
		return "customer/saveUI";
	}
	
	@RequestMapping(value = "/customer_save" )
	public String save(Customer customer){
		System.out.println(customer);
		System.out.println("the customer.name is ： " + customer.getName());
		customerService.addCustomer(customer);
		return "redirect:/customer/customer_list";
	}
	
	@RequestMapping(value = "/customer_update" )
	public String update(Customer customer){
		System.out.println("customer : " + customer);
			System.out.println("创建时间" + customer.getCreateTime());
			customerService.updateCustomer(customer);
			return "redirect:/customer/customer_list";
	}
				
	@RequestMapping(value = "/customer_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		customerService.deleteCustomerById(id);
		return "redirect:/customer/customer_list";
	}
	
	
}
