package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.SupplierMapper;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Supplier;
import com.future.hist.crm.service.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;

	public Supplier findSupplierById(int id) {

		return supplierMapper.findSupplierById(id);
	}

	public List<Supplier> findSupplierListByPage(BaseSearch baseSearch) {

		return supplierMapper.findSupplierListByPage(baseSearch);
	}
	
	public List<Supplier> findSupplierList() {

		return supplierMapper.findSupplierList();
	}

	public void addSupplier(Supplier supplier) {
		supplierMapper.addSupplier(supplier);

	}

	public void editSupplier(Supplier supplier) {
		supplierMapper.editSupplier(supplier);
	}

	public void deleteSupplier(int id) {
		supplierMapper.deleteSupplier(id);
	}

	public int getCount() {
		return supplierMapper.getCount();
	}


}
