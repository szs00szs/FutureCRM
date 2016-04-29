package com.future.hist.crm.dao;

import java.util.Date;
import java.util.List;

import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.User;

/**
 * @author 羊羊
 * @date 2016年4月9日
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
	 * 得到升序客户列表
	 * @return
	 */
	List<Customer> getAllCustomerByasc();
	
	/**
	 * 得到降序客户列表
	 * @return
	 */
	List<Customer> getAllCustomerBydesc();
	
	
	
	/**
	 * 得到用户的数量
	 * @return
	 */
	long getCustomerCount();
	
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
	 * 通过code模糊查找客户
	 * @param code
	 * @return
	 */
	List<Customer> getCustomerByCodeLike_(String _parameter);

	/**
	 * 通过Name得到客户
	 * 
	 * @param name
	 * @return
	 */
	Customer getCustomerByName(String name);
	
	/**
	 * 通过name模糊查询得到客户
	 * @param _parameter
	 * @return
	 */
	List<Customer> getCustomerByNameLike_(String _parameter);

	/**
	 * 通过grade得到客户
	 * 
	 * @param grade
	 * @return
	 */
	List<Customer> getCustomerByGrade(String grade);
	
	/**
	 * 通过来源得到客户
	 * 
	 * @param source
	 * @return
	 */
	List<Customer> getCustomerBySource(String source);
	
	
	/**
	 * 通过客户性质得到客户
	 * @param quality
	 * @return
	 */
	List<Customer> getCustomerByQuality(String quality);
	
	/**
	 * 通过联系人得到客户
	 * @param contacts
	 * @return
	 */
	List<Customer> getCustomerByContacts(Contacts contacts);
	
	/**
	 * 通过所属用户得到客户
	 * @param user
	 * @return
	 */
	List<Customer> getCustomerByUser(User user);
	
	/**
	 * 通过客户性质得到客户
	 * @param kind
	 * @return
	 */
	List<Customer> getCustomerByKind(String kind);

	//客户回访相关
	
	/**
	 * 通过联系时间返回需要回访的客户列表
	 * @param touchDate
	 * @return
	 */
	List<Customer> getCustomerByTouchDate(Date touchDate);
	
	/**
	 * 通过是否联系来得到需要回访的客户列表
	 * @param isTouched
	 * @return
	 */
	List<Customer> getCustomerByIsTouched(int isTouched);
}
