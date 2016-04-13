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

	@Override
	public void addCustomer(Customer customer) {
		customerMapper.addCustomer(customer);
	}

	@Override
	public void deleteCustomerById(long id) {
		customerMapper.deleteCustomerById(id);
	}

	@Override
	public void deleteCustomerByCode(String code) {
		customerMapper.deleteCustomerByCode(code);
	}

	@Override
	public void deleteCustomerByName(String name) {
		customerMapper.deleteCustomerByName(name);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}
	
	@Override
	public List<Customer> getAllCustomer(){
		return customerMapper.getAllCustomer();
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerMapper.getCustomerById(id);
	}

	@Override
	public Customer getCustomerByCode(String code) {
		return customerMapper.getCustomerByCode(code);
	}

	@Override
	public Customer getCustomerByName(String name) {
		return customerMapper.getCustomerByName(name);
	}

	@Override
	public List<Customer> getCustomerByGrade(String grade) {
		return customerMapper.getCustomerByGrade(grade);
	}

}
