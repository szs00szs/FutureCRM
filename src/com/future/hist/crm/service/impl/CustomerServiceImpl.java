package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.hist.crm.dao.CustomerMapper;
import com.future.hist.crm.domain.Customer;
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

	public Customer getCustomerById(long id) {
		return customerMapper.getCustomerById(id);
	}

	public Customer getCustomerByCode(String code) {
		return customerMapper.getCustomerByCode(code);
	}

	public Customer getCustomerByName(String name) {
		return customerMapper.getCustomerByName(name);
	}

	public List<Customer> getCustomerByGrade(String grade) {
		return customerMapper.getCustomerByGrade(grade);
	}

	@Override
	public List<Customer> getAllCustomerByasc() {
		return customerMapper.getAllCustomerByasc();
	}

	@Override
	public List<Customer> getAllCustomerBydesc() {
		return customerMapper.getAllCustomerBydesc();
	}

	@Override
	public long getCustomerCount() {
		return customerMapper.getCustomerCount();
	}

}
