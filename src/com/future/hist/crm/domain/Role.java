package com.future.hist.crm.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Role {

	private Long id;
	private String remark;     //备注
	private String name;       //名称
	private Set<User> users = new HashSet<User>();
	private List<Long> priIds; //拥有的资源
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public List<Long> getPriIds() {
		return priIds;
	}
	public void setPriIds(List<Long> priIds) {
		this.priIds = priIds;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", remark=" + remark + ", name=" + name + ", users=" + users + ", priIds=" + priIds
				+ "]";
	}
	
}
