package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.Customer;

/**
 * @author 羊羊
 * @date 2016年4月11日
 */
public interface CustomerMapper {
	/**
	 * 添加客户
	 * 
	 * @param customer
	 */
	void addCustomer(Customer customer);

	/**
	 * 通过ID删除客户
	 * 
	 * @param id
	 */
	void deleteCustomerById(long id);

	/**
	 * 通过Code删除客户
	 * 
	 * @param code
	 */
	void deleteCustomerByCode(String code);

	/**
	 * 通过Name删除客户
	 * 
	 * @param name
	 */
	void deleteCustomerByName(String name);

	/**
	 * 更新客户
	 * 
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * 得到全部客户
	 * @return
	 */
	List<Customer> getAllCustomer();
	
	/**
	 * 通过ID得到客户
	 * 
	 * @param id
	 * @return
	 */
	Customer getCustomerById(long id);

	/**
	 * 通过COde得到客户
	 * 
	 * @param code
	 * @return
	 */
	Customer getCustomerByCode(String code);

	/**
	 * 通过Name得到客户
	 * 
	 * @param name
	 * @return
	 */
	Customer getCustomerByName(String name);

	/**
	 * 通过grade得到客户
	 * 
	 * @param grade
	 * @return
	 */
	List<Customer> getCustomerByGrade(String grade);
}
