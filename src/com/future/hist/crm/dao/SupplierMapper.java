package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.Supplier;

public interface SupplierMapper {

	public Supplier findSupplierById(int id);

	public List<Supplier> findSupplierList();

	public void addSupplier(Supplier supplier);
	
	public void editSupplier(Supplier supplier);

	public void deleteSupplier(int id);

}
