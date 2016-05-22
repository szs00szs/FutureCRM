package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.PageParameter;
import com.future.hist.crm.domain.Supplier;
import com.future.hist.crm.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	// 查询所有供应商
	@RequiresPermissions("supplier:query")
	@RequestMapping("/querySuppliers/{currentPage}")
	public String querySuppliers(@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map) {
		BaseSearch baseSearch = new BaseSearch();
		int ordersCount = supplierService.getCount();
		PageParameter pageParameter = new PageParameter(PageParameter.DEFAULT_PAGE_SIZE, currentPage, ordersCount);
		baseSearch.setPage(pageParameter);

		List<Supplier> supplierList = supplierService.findSupplierListByPage(baseSearch);
		map.put("supplierList", supplierList);
		map.put("pageParameter", pageParameter);
		return "supplier/surpplierList";
	}

	// 添加供应商页面
	@RequiresPermissions("supplier:addSupplier")
	@RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
	public String addSupplierUI() {
		return "supplier/addSupplier";
	}

	// 执行供应商添加
	@RequiresPermissions("supplier:addSupplier")
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public String addSupplier(Supplier supplier) {
		supplierService.addSupplier(supplier);
		return "forward:querySuppliers.action";
	}

	// 修改供应商页面
	@RequiresPermissions("supplier:editSupplier")
	@RequestMapping(value = "/editSupplier", method = RequestMethod.GET)
	public String editSupplierUI(int id, Map<String, Object> map) {
		Supplier supplier = supplierService.findSupplierById(id);
		map.put("supplier", supplier);

		return "supplier/editSupplier";
	}

	// 修改供应商
	@RequiresPermissions("supplier:editSupplier")
	@RequestMapping(value = "/editSupplier", method = RequestMethod.POST)
	public String editSupplier(Supplier supplier) {
		supplierService.editSupplier(supplier);
		return "forward:querySuppliers.action";
	}

}
