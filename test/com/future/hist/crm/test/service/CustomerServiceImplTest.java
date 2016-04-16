package com.future.hist.crm.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.CustomerService;
import com.future.hist.crm.service.UserService;

/**
 * @author 羊羊
 * @date 2016年4月11日
 */
public class CustomerServiceImplTest {

	ApplicationContext applicationContext;
	CustomerService customerService;
	UserService userService;
	
	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:springbeans.xml");
		customerService = applicationContext.getBean(CustomerService.class);
		userService = applicationContext.getBean(UserService.class);
	}
	
	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setAccount("account");
		customer.setAddress("address");
		customer.setArtificialPerson("artificialPerson");
		customer.setBank("bank");
		customer.setCity("city");
		customer.setCode("code");
		Date createTime = new Date();
		customer.setCreateTime(createTime);
		customer.setCreator("creator");
		customer.setDealin("dealin");
		Date dispenseDate = new Date();
		customer.setDispenseDate(dispenseDate);
		customer.setDispensePerson("dispensePerson");
		customer.setEmail("email");
		
		customer.setGrade("grade1");
		
		customer.setKind("kind");
		customer.setMobile("mobile");
		
		customer.setName("客户1");
		
		Date nextTouchDate = new Date();
		customer.setNextTouchDate(nextTouchDate);
		customer.setPostCode("postcode");
		customer.setProvince("province");
		customer.setQuality("quality");
		customer.setRegionName("regionName");
		customer.setRegisteMoney("registeMoney");
		customer.setRemark("remark");
		customer.setScale("scale");
		customer.setShareFlag('a');
		customer.setShareIds("shareIds");
		customer.setSource("source");
		customer.setTaxCode("taxCode");
		customer.setTel1("tel1");
		customer.setTel2("tel2");
		customer.setTrade("trade");
		customer.setUpdater("updater");
		Date updateTime = new Date();
		customer.setUpdateTime(updateTime);
		
		
		customer.setWeb("web");
		
		customerService.addCustomer(customer);
		
		
		
	}

	@Test
	public void testDeleteCustomerById() {
		customerService.deleteCustomerById(2l);
	}

	@Test
	public void testDeleteCustomerByCode() {
		customerService.deleteCustomerByCode("code");
	}
	
	@Test
	public void testDeleteCustomerByName() {
		customerService.deleteCustomerByName("客户1");
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerService.getCustomerById(1l);
		customer.setCode("客户编号1");
		
		customerService.updateCustomer(customer);
	}

	@Test
	public void testGetAllCustomer(){
		List<Customer> list = customerService.getAllCustomer();
		for(Customer customer : list){
			System.out.println(customer);
		}
	}
	
	@Test
	public void testGetAllCustomerByasc(){
		List<Customer> list = customerService.getAllCustomerByasc();
		for(Customer customer : list){
			System.out.println(customer);
		}
	}
	
	@Test
	public void testGetAllCustomerBydesc(){
		List<Customer> list = customerService.getAllCustomerBydesc();
		for(Customer customer : list){
			System.out.println(customer);
		}
	}
	
	@Test
	public void testGetCustomerCount(){
		System.out.println(customerService.getCustomerCount());
	}
	
	@Test
	public void testGetCustomerById() {
		System.out.println(customerService.getCustomerById(1l));
	}

	@Test
	public void testGetCustomerByCode() {
		System.out.println(customerService.getCustomerByCode("code1"));
	}

	@Test
	public void testGetCustomerByName() {
		System.out.println(customerService.getCustomerByName("客户2"));
	}

	@Test
	public void testGetCustomerByGrade() {
		List<Customer> list = customerService.getCustomerByGrade("grade1");
		for(Customer customer : list){
			System.out.println(customer);
		}
	}

}
