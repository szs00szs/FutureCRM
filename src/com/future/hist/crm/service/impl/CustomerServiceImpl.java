package com.future.hist.crm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.hist.crm.dao.CustomerMapper;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.CustomerService;

/**
 * @author 羊羊
 * @date 2016年4月9日
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	public void addCustomer(Customer customer) {
		customerMapper.addCustomer(customer);
	}

	public void deleteCustomerById(long id) {
		customerMapper.deleteCustomerById(id);
	}

	public void deleteCustomerByCode(String code) {
		customerMapper.deleteCustomerByCode(code);
	}

	public void deleteCustomerByName(String name) {
		customerMapper.deleteCustomerByName(name);
	}

	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return customerMapper.getAllCustomer();
	}

	public int getAllCustomerCount(){
		return customerMapper.getAllCustomerCount();
	}
	
	public List<Customer> getAllCustomerByPage(BaseSearch baseSearch){
		return customerMapper.getAllCustomerByPage(baseSearch);
	}
	
	public Customer getCustomerById(long id) {
		return customerMapper.getCustomerById(id);
	}

	public Customer getCustomerByCode(String code) {
		return customerMapper.getCustomerByCode(code);
	}

	public List<Customer> getCustomerByCodeLike_(String code){
		return customerMapper.getCustomerByCodeLike_(code);
	}
	
	public Customer getCustomerByName(String name) {
		return customerMapper.getCustomerByName(name);
	}
	
	public List<Customer> getCustomerByNameLike_(String name){
		return customerMapper.getCustomerByNameLike_(name);
	}

	public List<Customer> getCustomerByGrade(String grade) {
		return customerMapper.getCustomerByGrade(grade);
	}

	public List<Customer> getAllCustomerByasc() {
		return customerMapper.getAllCustomerByasc();
	}

	public List<Customer> getAllCustomerBydesc() {
		return customerMapper.getAllCustomerBydesc();
	}

	public long getCustomerCount() {
		return customerMapper.getCustomerCount();
	}

	@Override
	public List<Customer> getCustomerBySource(String source) {
		return customerMapper.getCustomerBySource(source);
	}

	@Override
	public List<Customer> getCustomerByQuality(String quality) {
		return customerMapper.getCustomerByQuality(quality);
	}

	@Override
	public List<Customer> getCustomerByContacts(Contacts contacts) {
		return customerMapper.getCustomerByContacts(contacts);
	}

	@Override
	public List<Customer> getCustomerByUser(User user) {
		return customerMapper.getCustomerByUser(user);
	}
	
	public List<Customer> getCustomerByKind(String kind){
		return customerMapper.getCustomerByKind(kind);
	}
	
	public List<Customer> getCustomerByTouchDate(Date touchDate){
		return customerMapper.getCustomerByTouchDate(touchDate);
	}
	
	public List<Customer> getCustomerByIsTouched(int isTouched){
		return customerMapper.getCustomerByIsTouched(isTouched);
	}

}
