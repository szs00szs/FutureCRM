package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Supplier;
import com.future.hist.crm.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	// 查询所有供应商
	@RequestMapping("/querySuppliers")
	public String querySuppliers(Map<String, Object> map) {
		List<Supplier> supplierList = supplierService.findSupplierList();
		map.put("supplierList", supplierList);
		return "supplier/surpplierList";
	}

	// 添加供应商页面
	@RequestMapping("/addSupplierUI")
	public String addSupplierUI() {
		return "supplier/addSupplier";
	}

	// 执行供应商添加
	@RequestMapping("/addSupplier")
	public String addSupplier(Supplier supplier) {
		supplierService.addSupplier(supplier);
		return "forward:querySuppliers.action";
	}

	// 修改供应商页面
	@RequestMapping("/editSupplierUI")
	public String editSupplierUI(int id,Map<String, Object> map) {
		Supplier supplier = supplierService.findSupplierById(id);
		map.put("supplier", supplier);
		
		return "supplier/editSupplier";
	}

	// 修改供应商
	@RequestMapping("/editSupplier")
	public String editSupplier(Supplier supplier) {
		supplierService.editSupplier(supplier);
		return "forward:querySuppliers.action";
	}

}
