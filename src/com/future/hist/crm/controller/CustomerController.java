package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.ContactService;
import com.future.hist.crm.service.CustomerService;
import com.future.hist.crm.service.UserService;

/**
 * @author 羊羊
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private UserService userService;
	
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
	public String saveUI(Map<String, Object> map){
		List<Contacts> contactsList = contactService.getAllContacts();
		map.put("contactsList", contactsList);
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		return "customer/saveUI";
	}
	
	@RequestMapping(value = "/customer_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		Customer customer = customerService.getCustomerById(id);
		List<Contacts> contactsList = contactService.getAllContacts();
		map.put("contactsList", contactsList);
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		map.put("customer" , customer);
		return "customer/saveUI";
	}
	
	@RequestMapping(value = "/customer_save" )
	public String save(Customer customer){
		System.out.println(customer);
		customerService.addCustomer(customer);
		return "redirect:/customer/customer_list";
	}
	
	@RequestMapping(value = "/customer_update" )
	public String update(Customer customer){
		System.out.println("customer : " + customer);
		customerService.updateCustomer(customer);
		return "redirect:/customer/customer_list";
	}
				
	@RequestMapping(value = "/customer_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		customerService.deleteCustomerById(id);
		return "redirect:/customer/customer_list";
	}
	
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		System.out.println("the selectType is :" + selectType);
		System.out.println("the selectContent is : " + selectContent);
		List<Customer> customerList = new ArrayList<Customer>();
		switch (selectType) {
		case "name":
			customerList = customerService.getCustomerByNameLike_(selectContent);
			break;

		case "code":
			customerList = customerService.getCustomerByCodeLike_(selectContent);
			break;
		case "source":
			customerList = customerService.getCustomerBySource(selectContent);
			break;
		case "kind":
			customerList = customerService.getCustomerByKind(selectContent);
			break;
		case "contacts_name":
			List<Contacts> contactList = contactService.getContactsByNameLike_(selectContent);
			for(Contacts contact : contactList){
				List<Customer> list = customerService.getCustomerByContacts(contact);
				customerList.addAll(list);
			}
			break;
		case "user_name":
			List<User> userList = userService.getUserByNameLike_(selectContent);
			for(User user : userList){
				customerList.addAll(customerService.getCustomerByUser(user));
			}
			break;
		default:
			customerList = customerService.getAllCustomer();
			break;
		}
		map.put("customerList", customerList);
		return "customer/customer_list";
	}
}
