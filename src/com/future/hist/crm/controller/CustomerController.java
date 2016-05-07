package com.future.hist.crm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.ContactService;
import com.future.hist.crm.service.CustomerService;
import com.future.hist.crm.service.UserService;

/**
 * @author 羊羊
 * <p>
 * 顾客相关控制层
 * </p>
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {
	
	/**
	 * 客户serivce层
	 */
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 联系人service层
	 */
	@Autowired
	private ContactService contactService;
	
	/**
	 * 用户service层
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 获取客户列表
	 * @param map
	 * @return 客户列表的view视图
	 */
	@RequiresPermissions("customer:list")
	@RequestMapping("/customer_list")
	public String CustomerList(Map<String , Object> map){
		//得到所有的客户
		List<Customer> customerList =customerService.getAllCustomer();
		//放入map中
		map.put("customerList", customerList);
		
		return "customer/customer_list";
	}
	
	/**
	 * 查看客户详细信息
	 * @param map
	 * @param id ： 客户的id
	 * @return客户详细信息view视图
	 */
	@RequiresPermissions("customer:detail")
	@RequestMapping("/customer_detail/{id}")
	public String customerDetail(Map<String , Object> map ,@PathVariable("id") Long id){
		//通过id得到要查看的客户的信息
		Customer customer = customerService.getCustomerById(id);
//		System.out.println("the customer is " + customer);
		
		map.put("customer", customer);
		
		return "customer/customer_detail";
	}
	
	/**
	 * 添加客户请求
	 * @param map
	 * @return 
	 */
	@RequiresPermissions("customer:save")
	@RequestMapping(value = "/customer_save" , method = RequestMethod.GET)
	public String saveUI(Map<String, Object> map){
		//准备数据（联系人、用户列表），放入map中
		List<Contacts> contactsList = contactService.getAllContacts();
		map.put("contactsList", contactsList);
		
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		
		return "customer/saveUI";
	}
	
	/**
	 * 更新客户信息请求
	 * @param id ： 要更新的客户的id
	 * @param map
	 * @return
	 */
	@RequiresPermissions("customer:update")
	@RequestMapping(value = "/customer_update/{id}" , method = RequestMethod.POST)
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		//通过id得到要更新的客户的原始信息，并放入map中
		Customer customer = customerService.getCustomerById(id);
		map.put("customer" , customer);
		
		//准备数据（联系人、用户列表），放入map中
		List<Contacts> contactsList = contactService.getAllContacts();
		map.put("contactsList", contactsList);
		
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		
		return "customer/saveUI";
	}
	
	/**
	 * 添加客户
	 * @param customer
	 * @return
	 */
	@RequiresPermissions("customer:save")
	@RequestMapping(value = "/customer_save" ,method = RequestMethod.POST)
	public String save(Customer customer){
//		System.out.println(customer);
		
		customerService.addCustomer(customer);
		
		//重定向到客户列表
		return "redirect:/customer/customer_list";
	}
	
	/**
	 * 更新客户
	 * @param customer
	 * @return
	 */
	@RequiresPermissions("customer:update")
	@RequestMapping(value = "/customer_update" ,method = RequestMethod.POST)
	public String update(Customer customer){
//		System.out.println("customer : " + customer);
		
		customerService.updateCustomer(customer);
		//重定向到客户列表
		return "redirect:/customer/customer_list";
	}
			
				
	/**
	 * 通过id删除客户
	 * @param id：待删除的客户的id
	 * @return
	 */
	@RequiresPermissions("customer:delete")
	@RequestMapping(value = "/customer_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		
		customerService.deleteCustomerById(id);
		//重定向到客户列表
		return "redirect:/customer/customer_list";
	}
	
	/**
	 * 查询客户列表
	 * <p>
	 * 	通过不同的条件查找到不同的客户返回到客户列表
	 * 有六种查询条件：name（客户名）、code（客户编号）、source（客户来源）、kind（客户类型）、contacts_name（联系人姓名）、user_name（用户名）
	 * 默认范围所有客户列表
	 * </p>
	 * @param request
	 * @param map
	 * @return
	 */
	@RequiresPermissions("customer:query")
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		//查询条件，即根据什么查询客户
		String selectType = request.getParameter("selectType");
		//查询内容
		String selectContent = request.getParameter("selectContent");
		
//		System.out.println("the selectType is :" + selectType);
//		System.out.println("the selectContent is : " + selectContent);
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		switch (selectType) {
		case "name"://通过客户名称查找
			customerList = customerService.getCustomerByNameLike_(selectContent);
			break;

		case "code"://通过客户编号查找
			customerList = customerService.getCustomerByCodeLike_(selectContent);
			break;
			
		case "source"://通过客户来源查找
			customerList = customerService.getCustomerBySource(selectContent);
			break;
			
		case "kind"://通过客户类型查找
			customerList = customerService.getCustomerByKind(selectContent);
			break;
			
		case "contacts_name"://通过联系人查找
			List<Contacts> contactList = contactService.getContactsByNameLike_(selectContent);
			for(Contacts contact : contactList){
				List<Customer> list = customerService.getCustomerByContacts(contact);
				customerList.addAll(list);
			}
			break;
			
		case "user_name"://通过用户查找
			List<User> userList = userService.getUserByNameLike_(selectContent);
			for(User user : userList){
				customerList.addAll(customerService.getCustomerByUser(user));
			}
			break;
			
		default://默认范围所有客户列表
			customerList = customerService.getAllCustomer();
			break;
		}
		//将查找到的客户列表放入map中
		map.put("customerList", customerList);
		//返回到客户列表
		return "customer/customer_list";
	}
	

/***********************************客户回访相关************************************************/
	/**
	 * 回访客户列表
	 * <p>
	 * 	根据联系时间查询需要回访的客户列表
	 * 	如果联系时间大于当前时间并且isTouched字段为‘0’则为需要拜访
	 * </p>
	 * @return
	 * @throws ParseException 
	 */
	@RequiresPermissions("customer:touchCustomer_list")
	@RequestMapping("touchCustomer_list")
	public String touchCustomerList(Map<String , Object> map) throws ParseException{
		
		List<Customer> touchCustomerList = customerService.getCustomerByTouchDate(new Date());
		
		for(Customer customer : touchCustomerList){
			System.out.println(customer.getTouchDate());
		}
		
		map.put("touchCustomerList", touchCustomerList);
		
		return "customer/touchCustomer_list";
	}
	
	/**
	 * 发送邮件请求
	 * @param id ：客户id
	 * @return 跳转到发送邮件页面
	 */
	@RequiresPermissions("customer:toSendEmailPage")
	@RequestMapping(value = "toSendEmailPage/{id}")
	public ModelAndView ToSendEmailPage(@PathVariable(value="id") long id){
//		System.out.println("the customer id is : " + id);
		//通过id得到客户信息
		Customer customer = customerService.getCustomerById(id);
		
		ModelAndView mv = new ModelAndView("customer/sendEmail");
		mv.addObject("customer" , customer);//将客户信息放入到model中
		
		return mv;
	}
	
	/**
	 * 发送邮件
	 * <string>待实现</string>
	 * @param request
	 * @return
	 */
	@RequestMapping("sendEmail")
	public String sendEmail(HttpServletRequest request){
//		System.out.println(request.getParameter("customer_email"));
//		System.out.println(request.getParameter("content"));
		//TODO 实现邮件发送功能
		return "redirect:/customer/touchCustomer_list";
	}
	
	/**
	 * 查询客户列表
	 * <p>
	 * 	通过不同的条件查找到不同的客户返回到客户列表
	 * 有七种查询条件：isTOuched：是否联系、name（客户名）、code（客户编号）、source（客户来源）、kind（客户类型）、contacts_name（联系人姓名）、user_name（用户名）
	 * 默认范围所有客户列表
	 * </p>
	 * @param request
	 * @param map
	 * @return
	 */
	@RequiresPermissions("customer:touchQuery")
	@RequestMapping(value = "/touchQuery")
	public String touchQuery(HttpServletRequest request , Map<String , Object> map){
		//查询条件，即根据什么查询客户
		String selectType = request.getParameter("selectType");
		//查询内容
		String selectContent = request.getParameter("selectContent");
		
		List<Customer> touchCustomerList = new ArrayList<Customer>();
		
		switch (selectType) {
		case "isTouched"://通过是否联系查找
			if(selectContent.equals("待联系")){
				touchCustomerList = customerService.getCustomerByIsTouched(0);
			}else{//未联系 
				touchCustomerList = customerService.getCustomerByIsTouched(-1);
			}
			break;
			
		case "name"://通过客户名称查找
			touchCustomerList = customerService.getCustomerByNameLike_(selectContent);
			break;

		case "code"://通过客户编号查找
			touchCustomerList = customerService.getCustomerByCodeLike_(selectContent);
			break;
			
		case "source"://通过客户来源查找
			touchCustomerList = customerService.getCustomerBySource(selectContent);
			break;
			
		case "kind"://通过客户类型查找
			touchCustomerList = customerService.getCustomerByKind(selectContent);
			break;
			
		case "contacts_name"://通过联系人查找
			List<Contacts> contactList = contactService.getContactsByNameLike_(selectContent);
			for(Contacts contact : contactList){
				List<Customer> list = customerService.getCustomerByContacts(contact);
				touchCustomerList.addAll(list);
			}
			break;
			
		case "user_name"://通过用户查找
			List<User> userList = userService.getUserByNameLike_(selectContent);
			for(User user : userList){
				touchCustomerList.addAll(customerService.getCustomerByUser(user));
			}
			break;
			
		default://默认范围所有客户列表
			touchCustomerList = customerService.getCustomerByTouchDate(new Date());
			break;
		}
		//将查找到的客户列表放入map中
		map.put("touchCustomerList", touchCustomerList);
		//返回到客户列表
		return "customer/touchCustomer_list";
	}
}
