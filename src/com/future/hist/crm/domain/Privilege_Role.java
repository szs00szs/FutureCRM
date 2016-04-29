package com.future.hist.crm.domain;

public class Privilege_Role {

	private Long id;
	private Privilege privilege;
	private Role role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Privilege_Role [id=" + id + ", privilege=" + privilege + ", role=" + role + "]";
	}
	
}
