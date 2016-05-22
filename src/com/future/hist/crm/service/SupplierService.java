package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Supplier;

public interface SupplierService {
	public Supplier findSupplierById(int id);

	public List<Supplier> findSupplierListByPage(BaseSearch baseSearch);
	
	public List<Supplier> findSupplierList();

	public void addSupplier(Supplier supplier);

	public void editSupplier(Supplier supplier);

	public void deleteSupplier(int id);

	public int getCount();

}
