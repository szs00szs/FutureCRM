package com.future.hist.crm.domain;

import java.util.HashMap;
import java.util.Map;

public class BaseSearch {
	private PageParameter page;
	private String sort;
	private String dir = "asc";
	private Map<String, Object> map = new HashMap<String, Object>();
	public PageParameter getPage() {
		return page;
	}
	public void setPage(PageParameter page) {
		this.page = page;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
